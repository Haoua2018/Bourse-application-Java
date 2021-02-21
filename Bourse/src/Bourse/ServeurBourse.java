/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp3;
import java.net.*;
import java.rmi.*;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;

/**
 *UnicastRemoteObject implements ContratBourse
 *  public ServeurBourse() throws RemoteException{				/* Construc
	*	super();
	}
 * @author HAWA
 */
 class ServeurBourse  {

     
    
       	public static void main(String[] arg) {
		
         /*  try {
if (System.getSecurityManager() == null) {
System.setSecurityManager(new RMISecurityManager());
}
} catch (Exception e) {
e.printStackTrace();
        
}*/
            
            
            try {
			SqueletteBourse sq = new SqueletteBourse();			/* Squelette boursier */
			System.out.println("Mise en route du serveur boursier...");
			Naming.bind(ContratBourse.IDENTITEbourse,sq);			/* Enregistrement */
			//Naming.rebind(ContratBourse.IDENTITEbourse,sq);			/* Enregistrement */
                        System.out.println("Serveur boursier disponible...");
                        sq.start();
		} catch(Exception e) {
			System.err.println(e);
			System.exit(1);
		}
	}

   /* @Override
    public void connecter(String nom) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deconnecter(String nom) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}


