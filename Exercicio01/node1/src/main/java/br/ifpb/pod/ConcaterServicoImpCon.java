/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author ajp
 */
public class ConcaterServicoImpCon extends UnicastRemoteObject implements Concater {

    public ConcaterServicoImpCon() throws RemoteException {
    }

    @Override
    public String value1() throws RemoteException {
        return "Aluísio";
    }

    @Override
    public String value2() throws RemoteException {
        return "192.168.1.113";
    }

    @Override
    public void result(String result) throws RemoteException {
        System.out.println(result);

    }

}
