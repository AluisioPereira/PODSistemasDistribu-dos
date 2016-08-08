package br.ifpb.pod.dao2;

import br.ifpb.pod.*;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author ajp
 */
//servidor
public class Teste2 {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, Exception {
        Telefone t = new Telefone("(83)9998545");
        TelefoneDaoIf tdi = new TelefoneDao();
        tdi.adicionar(t);

    }

}
