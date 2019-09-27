package tier2_application;

public class Tier2 {

    public static void main(String[] args) {
        try {

            Tier2Controler t2 = new Tier2Controler();
            System.out.println("!!!!!! Tier2 App server ready!!!!!!!!!!!");

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
