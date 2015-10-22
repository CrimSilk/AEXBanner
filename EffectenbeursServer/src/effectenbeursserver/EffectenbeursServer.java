/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package effectenbeursserver;

import effectenbeursinterfaces.IEffectenbeurs;
import fontys.observer.BasicPublisher;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Jasper Rouwhorst
 */
public class EffectenbeursServer {
    private static Registry registry;
    private BasicPublisher publisher;

    private EffectenbeursServer() throws InterruptedException, RemoteException {
        IEffectenbeurs beurs = new MockEffectenbeurs();
        registry.rebind("beurs", beurs);

        publisher = new BasicPublisher(new String[]{
                "koersen"
        });

        //create loop that randomly refreshes the beurs(?) every 1-3 seconds
        while (true) {
            publisher.inform(this, "koersen", null, beurs.getKoersen());
            Thread.sleep((long) (1000 + 2000 * Math.random()));
        }
    }

    public static void main(String[] args) throws RemoteException {
        registry = LocateRegistry.createRegistry(1099);

        try {
            new EffectenbeursServer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
