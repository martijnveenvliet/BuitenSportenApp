package v3tomd.buitensportenapp.Database.DAO;

import java.util.List;

import v3tomd.buitensportenapp.Model.Gebruiker;

/**
 * Created by Martijn on 24-3-2016.
 */

public interface GebruikerDAO {
    public List<Gebruiker> getAllGebruikers();
    public Gebruiker getGebruiker(int gebruikerId);
    public void updateGebruiker(Gebruiker gebruiker);
    public void deleteGebruiker(Gebruiker gebruiker);
}

/*public class GebruikerDAO {



    private static GebruikerDAO MyInstance;

    private GebruikerDAO(){

    }


    public static GebruikerDAO getInstance(){
        if(MyInstance == null){
            MyInstance = new GebruikerDAO();
        }

        return MyInstance;
    }

    public Gebruiker getGebruikerByUsername(String Username){

        return new Gebruiker();
    }
}*/
