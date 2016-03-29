package v3tomd.buitensportenapp.Database.DTO;

import java.util.ArrayList;

import v3tomd.buitensportenapp.Model.Gebruiker;

/**
 * Created by Vidjinder on 28-3-2016.
 */
public class GebruikerDTO {
    private static GebruikerDTO MyInstance;
    private ArrayList<Gebruiker> gebruikers = new ArrayList<Gebruiker>();

    private GebruikerDTO(){

    }

    public static GebruikerDTO getInstance(){
        if(MyInstance == null){
            MyInstance = new GebruikerDTO();
        }

        return MyInstance;
    }


    public boolean AddGebruiker(Gebruiker MyGebruiker){


        Gebruiker curGebruiker = Gebruiker.GetGebruiker();


        if(curGebruiker.getMyNaam() != null) {
            gebruikers.add(MyGebruiker);
            //gelukt
            return true;
        }
        else {
            //mislukt return false;
            return false;
        }

    }

    public void updateGebruiker(Gebruiker gebruiker) {
        gebruikers.get(gebruiker.getMyID()).setMyNaam(gebruiker.getMyNaam());
        System.out.println("Gebruiker ID:  " + gebruiker.getMyID() +", updated in the database");
    }
}
