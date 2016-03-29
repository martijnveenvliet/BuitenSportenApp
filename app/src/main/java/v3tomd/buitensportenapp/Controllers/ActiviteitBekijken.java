package v3tomd.buitensportenapp.Controllers;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import v3tomd.buitensportenapp.Model.Activiteit;
import v3tomd.buitensportenapp.R;

/**
 * Created by Martijn on 29-3-2016.
 */
public class ActiviteitBekijken extends Activity {

    private Activiteit MyActiviteit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activteit_bekijken);

        MyActiviteit =  (Activiteit) getIntent().getSerializableExtra("activiteit");

        vulVelden();

    }

    private void vulVelden(){

        TextView tvTitle = (TextView) findViewById(R.id.tvTitel);
        tvTitle.setText(MyActiviteit.getTitel());
    }
}
