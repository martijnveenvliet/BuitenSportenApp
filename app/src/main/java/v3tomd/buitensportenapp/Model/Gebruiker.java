package v3tomd.buitensportenapp.Model;

import v3tomd.buitensportenapp.Database.DAO.GebruikerDAO;
import v3tomd.buitensportenapp.Utils.FacebookConnector;

/**
 * Created by Martijn on 24-3-2016.
 */
public class Gebruiker {


    private String MyNaam;
    private static Gebruiker CurGebruiker;

    public static boolean Login(String Username, String Password){


        CurGebruiker = GebruikerDAO.getInstance().getGebruikerByUsername(Username);

        return true;
    }

    public static boolean FacebookLogin(){


        CurGebruiker = FacebookConnector.getInstance().getGebruiker();

        return true;
    }


    public static Gebruiker GetGebruiker(){
        return CurGebruiker;
    }

}
