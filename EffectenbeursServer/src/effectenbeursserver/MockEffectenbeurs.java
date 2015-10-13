package effectenbeursserver;

import effectenbeursinterfaces.IEffectenbeurs;
import effectenbeursinterfaces.IFonds;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author ville
 */
public class MockEffectenbeurs extends UnicastRemoteObject implements IEffectenbeurs, Serializable {
    private List<MockFonds> fondsen = new ArrayList<MockFonds>();

    public MockEffectenbeurs() throws RemoteException {
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
    public List<IFonds> getKoersen() throws RemoteException {
        //change every fund's stock to a random number
        Random random = new Random();

        for (MockFonds fonds : fondsen) {
            fonds.setKoers((double) random.nextInt(100000) / 100);
        }

        return new ArrayList<IFonds>(fondsen);
    }
}
