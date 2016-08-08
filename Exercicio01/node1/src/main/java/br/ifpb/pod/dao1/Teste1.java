package br.ifpb.pod.dao1;

import br.ifpb.pod.*;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author ajp
 */
//servidor
public class Teste1 {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, Exception {
        Usuario u = new Usuario("Aluisio123");
        UsuariosDaoIf udi = new UsuarioDao();
        udi.adicionar(u);

    }

}
