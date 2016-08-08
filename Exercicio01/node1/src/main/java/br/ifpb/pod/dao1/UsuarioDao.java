package br.ifpb.pod.dao1;

import br.ifpb.pod.Usuario;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajp
 */
public class UsuarioDao implements UsuariosDaoIf {

    private Conexao1 conn;
    private String operacao = null;

    public UsuarioDao() {
    }

    /**
     *
     * @param usuario
     * @return
     */
    @Override
    public boolean adicionar(Usuario usuario) {
        boolean result = false;

        PreparedStatement stat = null;

        try {
            conn = new Conexao1();

            stat = conn.getConnection().prepareStatement("INSERT INTO usuario (nome) VALUES (?)");
            stat.setString(1, usuario.getNome());

            if (stat.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                conn.closeAll(stat);
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;

    }

    /**
     *
     * @param id
     * @return
     * @throws java.sql.SQLException
     * @throws Exception
     */
    @Override
    public Usuario buscarPorId(int id) throws Exception {
        operacao = "SELECT * FROM usuario WHERE id = '" + id + "'";
        return buscarUser(operacao).get(0);
    }

    /**
     *
     * @param nome
     * @return
     */
    @Override
    public List<Usuario> buscarPorNome(String nome) {

        List<Usuario> lista = new ArrayList<>();

        try {
            conn = new Conexao1();
            String consulta = "SELECT * FROM usuario WHERE nome ilike '%" + nome + "%'";
            PreparedStatement ps = conn.getConnection().prepareStatement(consulta);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(montarUsuario(rs));
            }
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    /**
     *
     * @return @throws Exception
     */
    @Override
    public List<Usuario> buscarTodos() throws Exception {
        operacao = "SELECT * FROM usuario";
        return buscarUser(operacao);

    }

    private List<Usuario> buscarUser(String sql) throws Exception {
        List<Usuario> lista = new ArrayList<>();

        PreparedStatement pst = null;

        try {
            conn = new Conexao1();
            pst = conn.getConnection().prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                lista.add(montarUsuario(rs));
            }

            conn.closeAll(pst);
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!lista.isEmpty()) {
            return lista;
        }
        return Collections.EMPTY_LIST;
    }

    private Usuario montarUsuario(ResultSet rs) throws SQLException {
        Usuario user = new Usuario();
        user.setId(rs.getInt("id"));
        user.setNome(rs.getString("nome"));

        return user;
    }

}
