/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author ajp
 */
public class ConcaterClient {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("192.168.1.107", 10999);
        Concater concater = (Concater) registry.lookup("Concater");

        String text = new StringBuffer().append("O estudante").append(concater.value1()).append("está servindo em").append(concater.value2()).toString();
        concater.result(text);
    }

}
