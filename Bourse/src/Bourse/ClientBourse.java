/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp3;

import java.io.IOException;
import java.rmi.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author HAWA
 */
 class ClientBourse extends UnicastRemoteObject implements ContratClient {

	public ClientBourse() throws RemoteException{				/* Constructeur */
		super();
	}

	public static void main(String[] arg) throws IOException, NotBoundException {
		new ClientBourse().tourner(arg[0]);
	}

        private void tourner(String nom) throws IOException, NotBoundException {	/* Activité principale */
		System.out.println("Client "+ nom + " en route...");
		/* Enregistrement au registre local */
		try {
			Naming.bind(nom,this);
		} catch(AlreadyBoundException e) {
			Naming.rebind(nom,this);
		}
		// Enregistrement au registre distant
		ContratBourse cb = (ContratBourse) Naming.lookup(ContratBourse.machine + ContratBourse.IDENTITEbourse);
		// Connexion au serveur boursier
		cb.connecter(nom);
	}

	public void alerter(String mess) throws RemoteException {		/* Rappel du client */
		System.out.println(mess);
	}
}
