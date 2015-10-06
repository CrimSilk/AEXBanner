package aexbanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author ville
 */
public class MockEffectenBeurs implements IEffectenBeurs {
    private List<IFonds> fondsen = new ArrayList<IFonds>();

    public MockEffectenBeurs() {
        //create 10 mocky mockfunds
        fondsen.addAll(Arrays.asList(
                new MockFonds("AEX", 0),
                new MockFonds("ASML", 0),
                new MockFonds("Shell", 0),
                new MockFonds("Heineken", 0),
                new MockFonds("OCI", 0),
                new MockFonds("Randstad", 0),
                new MockFonds("Vopak", 0),
                new MockFonds("Akzo Nobel", 0),
                new MockFonds("Aalberts", 0),
                new MockFonds("Ahold", 0)));
    }

    @Override
    public List<IFonds> getKoersen() {
        //change every fund's stock to a random number
        Random random = new Random();

        for (IFonds fonds : fondsen) {
            ((MockFonds) fonds).setKoers(random.nextInt(100000) / 100);
        }

        return fondsen;
    }
}