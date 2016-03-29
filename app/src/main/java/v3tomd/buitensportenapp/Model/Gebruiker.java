package v3tomd.buitensportenapp.Model;

import v3tomd.buitensportenapp.Database.DAO.Impl.DAOFacade;
import v3tomd.buitensportenapp.Utils.FacebookConnector;

/**
 * Created by Martijn on 24-3-2016.
 */
public class Gebruiker {




    private String MyNaam;
    private int myID;
    private static Gebruiker CurGebruiker;

    public static boolean Login(String Username, String Password){


        CurGebruiker = DAOFacade.getInstance().getMyGebruikerDAO().getGebruikerByUsername(Username);

        return true;
    }

    public static boolean FacebookLogin(){


        CurGebruiker = FacebookConnector.getInstance().getGebruiker();

        return true;
    }


    public static Gebruiker GetGebruiker(){
        return CurGebruiker;
    }

    public int getMyID() {
        return myID;
    }
    public String getMyNaam() {
        return MyNaam;
    }

    public void setMyNaam(String myNaam) {
        MyNaam = myNaam;
    }

}
