package v3tomd.buitensportenapp.Model;

import java.util.Date;

/**
 * Created by Martijn on 22-3-2016.
 */
public class Activiteit {

    public enum eSportType{
        Voetbal,
        Basketbal,
        Hockey,
        Tennis
    }

    private String MyTitel;
    private eSportType MySportType;
    private Date MyDate;
    private int MyMinLeeftijd;
    private int MyMaxLeeftijd;
    private int MyAantalDeelnemers;
    private int MyID;
    private Locatie MyLocatie;


}




