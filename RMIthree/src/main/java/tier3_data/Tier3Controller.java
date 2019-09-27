package tier3_data;

import common.ITier3;
import model.Account;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Tier3Controller extends UnicastRemoteObject implements ITier3 {

    private static final  long serialVersionUID = 1L;

    protected Tier3Controller() throws RemoteException {

        try {

            Registry registry = LocateRegistry.createRegistry(1888);
            registry.rebind(T3_SERVICE_NAME, this);
            System.out.println("Tier3  server registered/ bound, Do transactions");


            //lookup data tier3

        } catch (Exception ex) {
            System.err.println("Tier3Controler exception");
            ex.printStackTrace();
            System.exit(1);
        }

    }


        //mimic the database
        // Here you can put the real database coding
    private Account valeriu = new Account(1234, 12000.00);




    public Account getAccount(int anumber) throws RemoteException {

        if(anumber == 1234)
        {
            return valeriu;
        }
        else
        return null;
    }
}
