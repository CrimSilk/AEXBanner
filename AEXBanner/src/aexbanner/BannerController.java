/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import effectenbeursinterfaces.Fonds;
import effectenbeursinterfaces.IEffectenbeurs;
import effectenbeursinterfaces.IFonds;
import fontys.observer.RemotePropertyListener;

import java.beans.PropertyChangeEvent;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Timer;

/**
 * @author Jasper Rouwhorst
 */
public class BannerController extends UnicastRemoteObject implements RemotePropertyListener {
    private AEXBanner banner;

    public BannerController(AEXBanner banner) throws RemoteException {
        this.banner = banner;

        try {
            //subscribe to updates of remote publisher
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            IEffectenbeurs beurs = (IEffectenbeurs) registry.lookup("beurs");
            beurs.addListener(this, "koersen");
        } catch (NotBoundException ex) {
            banner.setKoersen("Geen beurs geregistreerd...");
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) throws RemoteException {
        switch (propertyChangeEvent.getPropertyName()) {
            case "koersen":
                updateKoersen((List<IFonds>) propertyChangeEvent.getNewValue());
                break;
        }
    }

    private void updateKoersen(List<IFonds> koersen) {
        String koersString = "";
        for(IFonds fonds : koersen){
            koersString += fonds.getNaam() + " " + String.format("%1$-7s", fonds.getKoers());
        }

        banner.setKoersen(koersString);
    }
}
