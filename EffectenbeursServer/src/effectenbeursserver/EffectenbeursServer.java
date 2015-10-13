/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package effectenbeursserver;

import effectenbeursinterfaces.IEffectenbeurs;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Jasper Rouwhorst
 */
public class EffectenbeursServer {

    private static Registry registry;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create RMI registry
        try {
            registry = LocateRegistry.createRegistry(1099);
        } catch (RemoteException ex){
            System.out.println(ex.toString());
        }
        
        try {
            IEffectenbeurs beurs = new MockEffectenbeurs();
            registry.rebind("EffectenBeurs", beurs);
        } catch (RemoteException ex){
            System.out.println(ex.toString());
        }
        
        
    }
    
}
