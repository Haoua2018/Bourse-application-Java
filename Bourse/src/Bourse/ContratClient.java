/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp3;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author HAWA
 */
interface ContratClient extends Remote {
	public void alerter(String mess) throws RemoteException;	/* Connexion au service client */
}
