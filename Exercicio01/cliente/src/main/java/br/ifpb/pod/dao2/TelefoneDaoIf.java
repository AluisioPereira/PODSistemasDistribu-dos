/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.dao2;

import br.ifpb.pod.Telefone;
import br.ifpb.pod.Usuario;
import java.util.List;

/**
 *
 * @author ajp
 */
public interface TelefoneDaoIf {

    public boolean adicionar(Telefone telefone) throws Exception;

    public Telefone buscarPorId(int id) throws Exception;

    public List<Telefone> buscarPorNumero(String nome) throws Exception;

    public List<Telefone> buscarTodos() throws Exception;
}
