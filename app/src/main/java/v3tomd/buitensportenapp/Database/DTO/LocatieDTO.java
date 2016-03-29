package v3tomd.buitensportenapp.Database.DTO;

import java.util.ArrayList;

import v3tomd.buitensportenapp.Model.Activiteit;
import v3tomd.buitensportenapp.Model.Locatie;

/**
 * Created by Vidjinder on 28-3-2016.
 */
public class LocatieDTO {
    private static LocatieDTO MyInstance;
    private ArrayList<Locatie> locaties = new ArrayList<Locatie>();

    private LocatieDTO(){

    }

    public static LocatieDTO getInstance(){
        if(MyInstance == null){
            MyInstance = new LocatieDTO();
        }

        return MyInstance;
    }


    public boolean AddLocatie(Locatie MyLocatie){



        if(MyLocatie != null) {
            locaties.add(MyLocatie);
            //gelukt
            return true;
        }
        else {
            //mislukt return false;
            return false;
        }

    }

    public void updateLocatie(Locatie locatie) {
        locaties.get(locatie.getMyID()).setLatitude(locatie.getLatitude());
        System.out.println("Locatie: " + locatie.getMyID() + ", updated in the database");
    }
}
