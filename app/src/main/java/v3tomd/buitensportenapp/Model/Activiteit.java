package v3tomd.buitensportenapp.Model;

import java.util.Date;

/**
 * Created by Martijn on 22-3-2016.
 */
public class Activiteit {

    private String MyTitel;
    private eSportType MySportType;
    private Date MyDate;
    private int MyMinLeeftijd;
    private int MyMaxLeeftijd;
    private int MyAantalDeelnemers;
    private int MyID;
    private Locatie MyLocatie;


    public Activiteit(int ID, String Titel, eSportType SportType, Date Date,  int MinLeeftijd, int MaxLeeftijd, Locatie Locatie) {
        MyID= ID;
        MyTitel = Titel;
        MySportType = SportType;
        MyDate = Date;
        MyMinLeeftijd = MinLeeftijd;
        MyMaxLeeftijd = MaxLeeftijd;
        MyLocatie = Locatie;
    }

    public Activiteit(String Titel, eSportType SportType, Date Date,  int MinLeeftijd, int MaxLeeftijd, Locatie Locatie){
        MyID = -1;
        MyTitel = Titel;
        MySportType = SportType;
        MyDate = Date;
        MyMinLeeftijd = MinLeeftijd;
        MyMaxLeeftijd = MaxLeeftijd;
        MyLocatie = Locatie;
    }


    public enum eSportType{
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

    public String getTitel() {
        return MyTitel;
    }

    public void setTitel(String myTitel) {
        MyTitel = myTitel;
    }

    public Date getDate() {
        return MyDate;
    }

    public void setDate(Date myDate) {
        MyDate = myDate;
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



}




