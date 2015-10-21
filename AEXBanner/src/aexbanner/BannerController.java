/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import java.util.Timer;

import effectenbeursinterfaces.IEffectenbeurs;
import javafx.fxml.Initializable;

/**
 * @author Jasper Rouwhorst
 */
public class BannerController {

    private AEXBanner banner;
    private IEffectenbeurs effectenbeurs;
    private Timer pollingTimer;

    public BannerController(AEXBanner banner) {

        this.banner = banner;

        // Start polling timer: update banner every two seconds
        pollingTimer = new Timer();
        try {
            pollingTimer.schedule(new UpdateBannerTask(banner), 2000, 2000);
        } catch (RemoteException e) {
            banner.setKoersen("Geen verbinding met server...");
        }
    }

    // Stop banner controller
    public void stop() {
        pollingTimer.cancel();
        // Stop simulation timer of effectenbeurs
    }


}
