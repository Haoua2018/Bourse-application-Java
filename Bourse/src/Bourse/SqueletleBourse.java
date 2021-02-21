/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp3;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

/**
 /* ************************************************************* */
/* Classe qui réalise le squelette de service boursier :	 */
/* c'est un thread qui se charge de la surveillance boursière    */
/* ************************************************************* */

 class SqueletteBourse extends UnicastRemoteObject implements ContratBourse, Runnable {
	ArrayList clients = new ArrayList();				/* Clients connectés */
	boolean fin = false;						/* Controle d'arrêt */

	public SqueletteBourse() throws RemoteException {		/* Constructeur */
		super();
	}

	public void start() {						/* Démarrage du thread */
		new Thread(this).start();
	}

        //connect function
	public void connecter(String nom) throws RemoteException {
          try {
		ContratClient cc = (ContratClient) Naming.lookup(nom);
                synchronized(clients) {
                  	clients.add(cc);
		}
          } catch(Exception e) {
                  System.err.println(e);
          }
	}
  // disconnect function
        
        
	public void run() {						/* Activité du thread */
		Iterator it;			                        // Pour balayer tous les clients
		Random rand = new Random();				// Service factice ! A remplacer
		while (!fin) {
			try {
				Thread.sleep(10*1000);			// Pause
			} catch(InterruptedException e) {
				System.out.println("Fin de surveillance...");
				fin = true;
			}
                        synchronized(clients) {
                                it = clients.iterator();
                                while (it.hasNext()) {
					// Message factice ! A remplacer par une véritable activité de surveillance
					String mesg = "Action en " + (rand.nextFloat() > 0.5 ? "hausse" : "baisse");
					// Tentative d'envoi au client. En cas d'échec, il est retiré de la liste
					try {
						((ContratClient) it.next()).alerter(mesg);
					} catch(RemoteException e) {
						it.remove();
					}
				}
			}
		}
	}

    @Override
    public void deconnecter(String nom) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
