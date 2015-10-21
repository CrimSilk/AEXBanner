package effectenbeursinterfaces;

import java.util.List;
import java.rmi.*;

/**
 * Created by ville on 6/10/2015.
 */
public interface IEffectenbeurs extends Remote{
    List<IFonds> getKoersen() throws RemoteException;
}
