package effectenbeursinterfaces;

import fontys.observer.RemotePublisher;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.rmi.*;

/**
 * Created by ville on 6/10/2015.
 */
public interface IEffectenbeurs extends RemotePublisher {
    List<IFonds> getKoersen() throws RemoteException;
}
