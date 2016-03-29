package v3tomd.buitensportenapp.Database.DTO;

import java.util.ArrayList;

import v3tomd.buitensportenapp.Model.Activiteit;
import v3tomd.buitensportenapp.Model.Gebruiker;

/**
 * Created by Martijn on 22-3-2016.
 */
public class ActiviteitDTO {

    private static ActiviteitDTO MyInstance;
    private ArrayList<Activiteit> activiteiten = new ArrayList<Activiteit>();

    private ActiviteitDTO(){

    }

    public static ActiviteitDTO getInstance(){
        if(MyInstance == null){
            MyInstance = new ActiviteitDTO();
        }

        return MyInstance;
    }


    public boolean AddActiviteit(Activiteit MyActiviteit){


       Gebruiker curGebruiker = Gebruiker.GetGebruiker();


        if(curGebruiker.getMyNaam() != null) {
            activiteiten.add(MyActiviteit);
            //gelukt
            return true;
        }
        else {
            //mislukt return false;
            return false;
        }

    }

    public void updateActiviteit(Activiteit activiteit) {
        activiteiten.get(activiteit.getMyID()).setTitel(activiteit.getTitel());
        System.out.println("Activiteit ID:  " + activiteit.getMyID() +", updated in the database");
    }

}
