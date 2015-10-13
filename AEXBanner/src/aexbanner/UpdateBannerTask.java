/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import effectenbeursserver.IFonds;
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
    private static Registry registry;
    
    public UpdateBannerTask(AEXBanner banner, IEffectenbeurs beurs){
        this.banner = banner;
        this.beurs = beurs;
    }
    
    @Override
    public void run() {
        try {
            registry = LocateRegistry.getRegistry(ipAddress,portNumber);
        } catch (RemoteException ex){
            System.out.println(ex.toString());
        }
        try {
                IPrinter printer = (IPrinter)registry.lookup("Printer");
                int jobId = printer.printJob("Hi");
        } catch (RemoteException exc) { … }

        fondslist = beurs.getKoersen();
        String koersen = "";
        for(IFonds fonds : fondslist){
            koersen += fonds.getNaam() + " " + String.format("%1$-7s", fonds.getKoers());
        }
        banner.setKoersen(koersen);
    }
    
}
