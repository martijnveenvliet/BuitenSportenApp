package v3tomd.buitensportenapp.Utils;

import v3tomd.buitensportenapp.Model.Gebruiker;

/**
 * Created by Martijn on 24-3-2016.
 */
public class FacebookConnector {


    private static FacebookConnector MyInstance;

    private FacebookConnector(){

    }


    public static FacebookConnector getInstance(){
        if(MyInstance == null){
            MyInstance = new FacebookConnector();
        }

        return MyInstance;
    }

    public Gebruiker getGebruiker(){

        return new Gebruiker();
    }
}
