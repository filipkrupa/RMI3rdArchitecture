package tier2_application;

import common.ITier2;
import common.ITier3;
import model.Account;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Tier2Controler extends UnicastRemoteObject implements ITier2 {

    private static final  long serialVersionUID = 1L;
    private ITier3 tier3;

    protected Tier2Controler() throws RemoteException {

        try {

            Registry registry = LocateRegistry.createRegistry(1888);
            registry.rebind(T2_SERVICE_NAME, this);
            System.out.println("Tier2 Application server registered/ bound");


            //lookup data tier3
            Registry reg2 = LocateRegistry.getRegistry(1889);
            tier3 = (ITier3) reg2.lookup(ITier3.T3_SERVICE_NAME);

        } catch (Exception ex) {
            System.err.println("Tier2Controler exception");
            ex.printStackTrace();
        }

    }

    public boolean withdraw(int number, double amount) throws RemoteException {
        // get account from data tier (database)

        Account account = tier3.getAccount(number);
        if(account==null)
        {
            return false;
        }
        else if (amount <= 0.0 || amount > account.getBalance())
            return false;
        else{
            account.updateBalance(-amount);
            //tier3.updateAccount(ac);
            return true;
        }

    }
}
