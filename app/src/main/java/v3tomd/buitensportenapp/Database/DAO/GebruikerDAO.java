package v3tomd.buitensportenapp.Database.DAO;

import v3tomd.buitensportenapp.Model.Gebruiker;

/**
 * Created by Martijn on 24-3-2016.
 */
public class GebruikerDAO {



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
}
