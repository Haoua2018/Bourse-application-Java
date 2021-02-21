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
 * * *************************************************
 */
/* Classe qui définit le contrat du service boursier */
/* ************************************************* */
 interface ContratBourse  extends Remote {
	public final static String machine = "rmi://localhost/";
	public static final String IDENTITEbourse = "ServiceBoursier";  /* Pour l'enregistrement */
	public void connecter(String nom) throws RemoteException;	/* Connexion au service boursier */
        public void deconnecter(String nom) throws RemoteException;	/* Connexion au service boursier */
}