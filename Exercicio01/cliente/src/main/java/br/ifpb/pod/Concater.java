/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author ajp
 */
public interface Concater extends Remote {

    String value1() throws RemoteException;

    String value2() throws RemoteException;

    void result(String result) throws RemoteException;

}
