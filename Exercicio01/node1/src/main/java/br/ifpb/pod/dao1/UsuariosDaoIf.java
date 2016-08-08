/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.dao1;

import br.ifpb.pod.Usuario;
import java.util.List;

/**
 *
 * @author ajp
 */
public interface UsuariosDaoIf {

    public boolean adicionar(Usuario usuario) throws Exception;

    public Usuario buscarPorId(int id) throws Exception;

    public List<Usuario> buscarPorNome(String nome) throws Exception;

    public List<Usuario> buscarTodos() throws Exception;
}
