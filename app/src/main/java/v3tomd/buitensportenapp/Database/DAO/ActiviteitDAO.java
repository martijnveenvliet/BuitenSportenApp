package v3tomd.buitensportenapp.Database.DAO;

import java.util.ArrayList;
import java.util.Date;

import v3tomd.buitensportenapp.Model.Activiteit;
import v3tomd.buitensportenapp.Model.Locatie;

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

        ArrayList<Activiteit> activiteiten = new ArrayList<Activiteit>();

        Locatie MyLocatie = new Locatie(52.103178, 5.105735);
        Activiteit MyActivity = new Activiteit("Voetbal", Activiteit.eSportType.Voetbal, new Date(), 1, 99,  MyLocatie);
        activiteiten.add(MyActivity);


        MyLocatie = new Locatie(52.102795, 5.108324);
        MyActivity = new Activiteit("Basketbal", Activiteit.eSportType.Basketbal, new Date(), 1, 99,  MyLocatie);
        activiteiten.add(MyActivity);

        return activiteiten;
    }

}
