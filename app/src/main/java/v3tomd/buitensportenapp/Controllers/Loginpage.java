package v3tomd.buitensportenapp.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import v3tomd.buitensportenapp.Model.Gebruiker;
import v3tomd.buitensportenapp.R;

public class Loginpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
    }



    private void LoginClicked(View v){
        Boolean bLoginSucceeded = Gebruiker.Login("", "");

        if(bLoginSucceeded){
            Intent newIntent = new Intent(this, Homepage.class);
        }else{
            // Message foute inloggegevens

        }
    }


    private void LoginMetFacebook(View v){
        Boolean bLoginSucceeded = Gebruiker.FacebookLogin("", "");

        if(bLoginSucceeded){
            Intent newIntent = new Intent(this, Homepage.class);
        }else{
            // Message foute inloggegevens

        }
    }


}
