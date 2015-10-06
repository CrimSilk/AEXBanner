/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

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
    
    public UpdateBannerTask(AEXBanner banner, IEffectenbeurs beurs){
        this.banner = banner;
        this.beurs = beurs;
    }
    
    @Override
    public void run() {
        fondslist = beurs.getKoersen();
        String koersen = "";
        for(IFonds fonds : fondslist){
            koersen += fonds.getNaam() + " " + fonds.getKoers() + " - ";
        }
        banner.setKoersen(koersen);
    }
    
}
