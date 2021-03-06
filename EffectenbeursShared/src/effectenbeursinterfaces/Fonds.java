package effectenbeursinterfaces;

import java.io.Serializable;

/**
 * Created by ville on 6/10/2015.
 */
public class Fonds implements IFonds, Serializable {
    private String naam;
    private double koers;

    public Fonds(String naam, double koers) {
        this.naam = naam;
        this.koers = koers;
    }

    @Override
    public String getNaam() {
        return naam;
    }

    @Override
    public double getKoers() {
        return koers;
    }

    public void setKoers(double value) {
        koers = value;
    }
}
