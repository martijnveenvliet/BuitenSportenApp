package v3tomd.buitensportenapp.Database.DAO;

import java.util.ArrayList;

import v3tomd.buitensportenapp.Model.Activiteit;

/**
 * Created by Martijn on 22-3-2016.
 */
public class ActiviteitDAO {

    private static ActiviteitDAO MyInstance;

    private ActiviteitDAO(){

    }


    public static ActiviteitDAO getInstance(){
        if(MyInstance == null){
            MyInstance = new ActiviteitDAO();
        }

        return MyInstance;
    }

    public ArrayList<Activiteit> getAlleActiviteiten(){


        return null;
    }

}
