package v3tomd.buitensportenapp.Controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import v3tomd.buitensportenapp.CustomViews.GoogleMapsActivity;
import v3tomd.buitensportenapp.GridView.GridViewAdapter;
import v3tomd.buitensportenapp.GridView.ItemObject;
import v3tomd.buitensportenapp.R;


public class HomePage extends AppCompatActivity {

    private StaggeredGridLayoutManager gaggeredGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
        recyclerView.setLayoutManager(gaggeredGridLayoutManager);

        List<ItemObject> gaggeredList = getListItemData();

        GridViewAdapter rcAdapter = new GridViewAdapter(HomePage.this, gaggeredList);
        recyclerView.setAdapter(rcAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<ItemObject> getListItemData(){
        List<ItemObject> listViewItems = new ArrayList<ItemObject>();

        listViewItems.add(new ItemObject("Kaart", R.drawable.maps, GoogleMapsActivity.class));
//        listViewItems.add(new ItemObject("Ethane", R.drawable.two));
//        listViewItems.add(new ItemObject("Alkyne", R.drawable.three));
//        listViewItems.add(new ItemObject("Benzene", R.drawable.four));
//        listViewItems.add(new ItemObject("Amide", R.drawable.one));
//        listViewItems.add(new ItemObject("Amino Acid", R.drawable.two));
//        listViewItems.add(new ItemObject("Phenol", R.drawable.three));
//        listViewItems.add(new ItemObject("Carbonxylic", R.drawable.four));
//        listViewItems.add(new ItemObject("Nitril", R.drawable.one));
//        listViewItems.add(new ItemObject("Ether", R.drawable.two));
//        listViewItems.add(new ItemObject("Ester", R.drawable.three));
//        listViewItems.add(new ItemObject("Alcohol", R.drawable.four));

        return listViewItems;
    }




}