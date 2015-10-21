/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import effectenbeursinterfaces.IEffectenbeurs;
import effectenbeursinterfaces.IFonds;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.TimerTask;
import java.util.List;

/**
 *
 * @author Jasper Rouwhorst
 */
public class UpdateBannerTask extends TimerTask {
    private AEXBanner banner;
    private IEffectenbeurs beurs;
    private List<IFonds> fondslist;
    
    public UpdateBannerTask(AEXBanner banner) throws RemoteException {
        this.banner = banner;

        Registry registry = LocateRegistry.getRegistry("localhost", 1099);

        try {
            beurs = (IEffectenbeurs) registry.lookup("EffectenBeurs");
        } catch (NotBoundException ex) {
            throw new RemoteException("Could not obtain EffectenBeurs.", ex);
        }
    }
    
    @Override
    public void run() {
        try {
            fondslist = beurs.getKoersen();

            String koersen = "";
            for(IFonds fonds : fondslist){
                koersen += fonds.getNaam() + " " + String.format("%1$-7s", fonds.getKoers());
            }
            banner.setKoersen(koersen);
        } catch (RemoteException ex) {
            System.out.println(ex.toString());
        }
    }
}
