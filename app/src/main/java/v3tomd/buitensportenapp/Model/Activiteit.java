package v3tomd.buitensportenapp.Model;

import android.util.Log;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Martijn on 22-3-2016.
 */
public class Activiteit implements Serializable {

    private String MyTitel;
    private eSportType MySportType;
    private Date MyStartDate;

    public Date getMyEndDate() {
        return MyEndDate;
    }

    public void setMyEndDate(Date myEndDate) {
        MyEndDate = myEndDate;
    }

    private Date MyEndDate;
    private int MyMinLeeftijd;
    private int MyMaxLeeftijd;
    private int MyAantalDeelnemers;

    public int getMyMaxAantalDeelnemers() {
        return MyMaxAantalDeelnemers;
    }

    public void setMyMaxAantalDeelnemers(int myMaxAantalDeelnemers) {
        MyMaxAantalDeelnemers = myMaxAantalDeelnemers;
    }

    private int MyMaxAantalDeelnemers;
    private int MyID;
    private Locatie MyLocatie;


    public Activiteit(int ID, String Titel, eSportType SportType, Date Date, Date EndDate, int MinLeeftijd, int MaxLeeftijd, int AantalDeelnemers, int MaxAantalDeelnemers, Locatie Locatie) {
        MyID = ID;
        MyTitel = Titel;
        MySportType = SportType;
        MyStartDate = Date;
        MyEndDate = EndDate;
        MyMinLeeftijd = MinLeeftijd;
        MyMaxLeeftijd = MaxLeeftijd;
        MyMaxAantalDeelnemers = MaxAantalDeelnemers;
        MyAantalDeelnemers = AantalDeelnemers;
        MyLocatie = Locatie;
    }

    public Activiteit(String Titel, eSportType SportType, Date Date, Date EndDate, int MinLeeftijd, int MaxLeeftijd, int AantalDeelnemers, int MaxAantalDeelnemers, Locatie Locatie) {
        MyID = -1;
        MyTitel = Titel;
        MySportType = SportType;
        MyStartDate = Date;
        MyEndDate = EndDate;
        MyMinLeeftijd = MinLeeftijd;
        MyMaxLeeftijd = MaxLeeftijd;
        MyAantalDeelnemers = AantalDeelnemers;
        MyMaxAantalDeelnemers = MaxAantalDeelnemers;
        MyLocatie = Locatie;
    }


    public enum eSportType {
        Voetbal,
        Basketbal,
        Hockey,
        Tennis
    }

    public int getMyID() {
        return MyID;
    }


    public eSportType getSportType() {
        return MySportType;
    }

    public void setSportType(eSportType mySportType) {
        MySportType = mySportType;
    }

    public String getSportTypeString() {
        switch (MySportType) {
            case Voetbal:
                return "Voetbal";
            case Basketbal:
                return "Basketbal";
            case Hockey:
                return "Hockey";
            case Tennis:
                return "Tennis";
            default:
                return "";
        }
    }

    public String getTitel() {
        return MyTitel;
    }

    public void setTitel(String myTitel) {
        MyTitel = myTitel;
    }

    public Date getStartDate() {
        return MyStartDate;
    }

    public void setStartDate(Date myDate) {
        MyStartDate = myDate;
    }

    public int getMinLeeftijd() {
        return MyMinLeeftijd;
    }

    public void setMinLeeftijd(int myMinLeeftijd) {
        MyMinLeeftijd = myMinLeeftijd;
    }

    public int getMaxLeeftijd() {
        return MyMaxLeeftijd;
    }

    public void setMaxLeeftijd(int myMaxLeeftijd) {
        MyMaxLeeftijd = myMaxLeeftijd;
    }

    public int getAantalDeelnemers() {
        return MyAantalDeelnemers;
    }

    public void setMantalDeelnemers(int myAantalDeelnemers) {
        MyAantalDeelnemers = myAantalDeelnemers;
    }

    public Locatie getLocatie() {
        return MyLocatie;
    }

    public void setLocatie(Locatie myLocatie) {
        MyLocatie = myLocatie;
    }


    public String getMarkerText() {
        String sReturn = "";
        SimpleDateFormat simpleDate =  new SimpleDateFormat("HH-mm");

        sReturn = simpleDate.format(getStartDate()) + " - " + simpleDate.format(getMyEndDate());
        sReturn += "\n" + getSportTypeString();
        sReturn += "\nDeelnemers: " + MyAantalDeelnemers + '/' + MyMaxAantalDeelnemers;
        sReturn += "\nMin/Max leeftijd: " + MyMinLeeftijd + "/" + MyMaxLeeftijd;

        sReturn += "\n\nKlik hier voor meer informatie.";

        Log.i("getMarkerText: ", sReturn);
        return sReturn;
    }
}




