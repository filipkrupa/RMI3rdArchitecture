package common;

import model.Account;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITier3 extends Remote {

    public Account getAccount(int anumber) throws RemoteException;
    //void updageAccount
    public static final String T3_SERVICE_NAME = "rmi://localhost/T3";


}
