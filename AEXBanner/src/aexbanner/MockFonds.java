package aexbanner;

/**
 * Created by ville on 6/10/2015.
 */
public class MockFonds implements IFonds {
    private String naam;
    private double koers;

    public MockFonds(String naam, double koers) {
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