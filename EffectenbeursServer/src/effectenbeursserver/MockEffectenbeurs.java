package effectenbeursserver;

import effectenbeursinterfaces.Fonds;
import effectenbeursinterfaces.IEffectenbeurs;
import effectenbeursinterfaces.IFonds;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author ville
 */
public class MockEffectenbeurs extends UnicastRemoteObject implements IEffectenbeurs {
    private List<Fonds> fondsen = new ArrayList<Fonds>();

    public MockEffectenbeurs() throws RemoteException {
        //create 10 mocky mockfunds
        fondsen.addAll(Arrays.asList(
                new Fonds("AEX", 0),
                new Fonds("ASML", 0),
                new Fonds("Shell", 0),
                new Fonds("Heineken", 0),
                new Fonds("OCI", 0),
                new Fonds("Randstad", 0),
                new Fonds("Vopak", 0),
                new Fonds("Akzo Nobel", 0),
                new Fonds("Aalberts", 0),
                new Fonds("Ahold", 0)));
    }

    @Override
    public List<IFonds> getKoersen() throws RemoteException {
        //change every fund's stock to a random number
        Random random = new Random();

        for (Fonds fonds : fondsen) {
            fonds.setKoers((double) random.nextInt(100000) / 100);
        }

        return new ArrayList<IFonds>(fondsen);
    }
}
