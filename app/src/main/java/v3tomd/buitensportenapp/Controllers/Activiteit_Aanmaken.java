package v3tomd.buitensportenapp.Controllers;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import java.util.Date;

import v3tomd.buitensportenapp.Database.DTO.ActiviteitDTO;
import v3tomd.buitensportenapp.Model.Activiteit;
import v3tomd.buitensportenapp.Model.Locatie;

/**
 * Created by Martijn on 24-3-2016.
 */
public class Activiteit_Aanmaken extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_loginpage);
    }

    private void MaakActiviteit(View v){
//        String Titel, eSportType SportType, Date Date,  int MinLeeftijd, int MaxLeeftijg, Locatie myLocatie

        String Titel = "";
        Activiteit.eSportType SportType = Activiteit.eSportType.Voetbal;
        Date Date = new Date();
        int MinLeeftijd = 1;
        int MaxLeeftijd = 99;
        Locatie MyLocatie = new Locatie();

        ActiviteitDTO.getInstance().AddActiviteit(new Activiteit(Titel, SportType, Date, MinLeeftijd, MaxLeeftijd, MyLocatie));

    }
}
