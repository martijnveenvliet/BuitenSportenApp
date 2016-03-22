package v3tomd.buitensportenapp.Database.DTO;

import v3tomd.buitensportenapp.Model.Activiteit;

/**
 * Created by Martijn on 22-3-2016.
 */
public class ActiviteitDTO {

    private static ActiviteitDTO MyInstance;

    private ActiviteitDTO(){

    }

    public static ActiviteitDTO getInstance(){
        if(MyInstance == null){
            MyInstance = new ActiviteitDTO();
        }

        return MyInstance;
    }


    public boolean AddActiviteit(Activiteit MyActiviteit){


        //gelukt
        return true;


                //mislukt return false;
    }

}
