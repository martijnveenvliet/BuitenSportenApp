package v3tomd.buitensportenapp.Controllers;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import java.util.Date;

import v3tomd.buitensportenapp.Database.DTO.ActiviteitDTO;
import v3tomd.buitensportenapp.Model.Activiteit;
import v3tomd.buitensportenapp.Model.Locatie;
import v3tomd.buitensportenapp.R;

public class ActiviteitAanmaken extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_activiteit_aanmaken);
    }

    private void MaakActiviteit(View v){
//        String Titel, eSportType SportType, Date Date,  int MinLeeftijd, int MaxLeeftijg, Locatie myLocatie

        String Titel = "";
        Activiteit.eSportType SportType = Activiteit.eSportType.Voetbal;
        Date StartDate = new Date();
        Date EndDate = new Date(StartDate.getTime() + 1000 * 60  * 60);
        int MinLeeftijd = 1;
        int MaxLeeftijd = 99;
        int AantalDeelnemers = 0;
        int MaxAantalDeelnemers = 0;
        Locatie MyLocatie = new Locatie(52.103178, 5.105735);

        ActiviteitDTO.getInstance().AddActiviteit(new Activiteit(Titel, SportType, StartDate, EndDate, MinLeeftijd, MaxLeeftijd,AantalDeelnemers, MaxAantalDeelnemers,  MyLocatie));

    }
}
