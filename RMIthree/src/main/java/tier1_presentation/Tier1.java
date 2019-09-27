package tier1_presentation;

import common.ITier2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Tier1 {

    public static void main(String[] args) {

        try{
            Registry reg1 = LocateRegistry.getRegistry(1888);
            ITier2 tier2 = (ITier2) reg1.lookup(ITier2.T2_SERVICE_NAME);
            double amount = 5000.00;
            while (tier2.withdraw(1234,amount))
                System.out.println("- withdrawn" + amount);


        }
        catch (Exception ex){
            ex.printStackTrace();
        }


    }


}
