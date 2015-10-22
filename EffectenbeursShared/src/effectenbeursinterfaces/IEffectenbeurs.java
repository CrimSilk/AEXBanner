package effectenbeursinterfaces;

import fontys.observer.RemotePublisher;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by ville on 6/10/2015.
 */
public interface IEffectenbeurs extends RemotePublisher {
    List<IFonds> getKoersen() throws RemoteException;
}
