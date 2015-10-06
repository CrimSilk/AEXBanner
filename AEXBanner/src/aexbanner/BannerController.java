/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import java.util.Timer;
import javafx.fxml.Initializable;

/**
 *
 * @author Jasper Rouwhorst
 */
public class BannerController implements Initializable {
    
    private AEXBanner banner;
    private IEffectenBeurs effectenbeurs;
    private Timer pollingTimer;

    public BannerController(AEXBanner banner) {

        this.banner = banner;
        this.effectenbeurs = new MockEffectenbeurs();
        
        // Start polling timer: update banner every two seconds
        pollingTimer = new Timer();
        pollingTimer.schedule(new UpdateBannerTask(effectenbeurs), 2000);
        // TODO
    }

    // Stop banner controller
    public void stop() {
        pollingTimer.cancel();
        // Stop simulation timer of effectenbeurs
    }
 
    
}