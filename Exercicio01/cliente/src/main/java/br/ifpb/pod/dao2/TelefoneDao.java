package br.ifpb.pod.dao2;

import br.ifpb.pod.Telefone;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger; // vinicio dantas facebook

/**
 *
 * @author ajp
 */
public class TelefoneDao implements TelefoneDaoIf {

    private Conexao2 conn;
    private String operacao = null;

    public TelefoneDao() {
    }

    /**
     *
     * @param telefone
     * @return
     */
    @Override
    public boolean adicionar(Telefone telefone) {
        boolean result = false;

        PreparedStatement stat = null;

        try {
            conn = new Conexao2();

            stat = conn.getConnection().prepareStatement("INSERT INTO telefone (numero) VALUES (?)");
            stat.setString(1, telefone.getNumero());

            if (stat.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(TelefoneDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                conn.closeAll(stat);
            } catch (Exception ex) {
                Logger.getLogger(TelefoneDao.class.getName()).log(Level.SEVERE, null, ex);
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
    public Telefone buscarPorId(int id) throws Exception {
        operacao = "SELECT * FROM telefone WHERE id = '" + id + "'";
        return buscarTelefone(operacao).get(0);
    }

    /**
     *
     * @param numero
     * @return
     */
    @Override
    public List<Telefone> buscarPorNumero(String numero) {

        List<Telefone> lista = new ArrayList<>();

        try {
            conn = new Conexao2();
            String consulta = "SELECT * FROM telefone WHERE numero ilike '%" + numero + "%'";
            PreparedStatement ps = conn.getConnection().prepareStatement(consulta);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(montarTelefone(rs));
            }
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(TelefoneDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    /**
     *
     * @return @throws Exception
     */
    @Override
    public List<Telefone> buscarTodos() throws Exception {
        operacao = "SELECT * FROM telefone";
        return buscarTelefone(operacao);

    }

    private List<Telefone> buscarTelefone(String sql) throws Exception {
        List<Telefone> lista = new ArrayList<>();

        PreparedStatement pst = null;

        try {
            conn = new Conexao2();
            pst = conn.getConnection().prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                lista.add(montarTelefone(rs));
            }

            conn.closeAll(pst);
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(TelefoneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!lista.isEmpty()) {
            return lista;
        }
        return Collections.EMPTY_LIST;
    }

    private Telefone montarTelefone(ResultSet rs) throws SQLException {
        Telefone tel = new Telefone();
        tel.setId(rs.getInt("id"));
        tel.setNumero(rs.getString("numero"));

        return tel;
    }

}
