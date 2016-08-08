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
        Registry registry1 = LocateRegistry.getRegistry("192.168.1.107", 10999);
        Concater concater1 = (Concater) registry1.lookup("Concater");
        String text1 = new StringBuffer().append("O estudante").append(concater1.value1()).append("está servindo em").append(concater1.value2()).toString();
        concater1.result(text1);
        
       
        Registry registry2 = LocateRegistry.getRegistry("locahost", 5432);
        Concater concater2 = (Concater) registry2.lookup("Concater");
        String text2 = new StringBuffer().append("O estudante").append(concater2.value1()).append("está servindo em").append(concater2.value2()).toString();
        concater2.result(text2);
        
    }

}
