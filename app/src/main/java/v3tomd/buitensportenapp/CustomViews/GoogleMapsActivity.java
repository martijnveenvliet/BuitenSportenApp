package v3tomd.buitensportenapp.CustomViews;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;

import v3tomd.buitensportenapp.Controllers.ActiviteitBekijken;
import v3tomd.buitensportenapp.Database.DAO.Impl.DAOFacade;
import v3tomd.buitensportenapp.Model.Activiteit;
import v3tomd.buitensportenapp.R;

public class GoogleMapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener{

    class MyInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

        private final View myContentsView;

        MyInfoWindowAdapter() {
            myContentsView = getLayoutInflater().inflate(R.layout.item_marker_details, null);
        }

        @Override
        public View getInfoWindow(Marker marker) {
            return null;
        }

        @Override
        public View getInfoContents(Marker marker) {

            //Julien: Hier worden de contents gezet.

            TextView tvTitle = ((TextView)myContentsView.findViewById(R.id.title));
            tvTitle.setText(marker.getTitle());
            TextView tvSnippet = ((TextView)myContentsView.findViewById(R.id.snippet));
            tvSnippet.setText(marker.getSnippet());

            return myContentsView;
        }
    }

    private GoogleMap mMap;
    private LocationManager locationManager;
    private static final long MIN_TIME = 5000;
    private static final float MIN_DISTANCE = 20;
    private static final float Zoom = 15;
    private Marker MyLocationMarker;
    private HashMap<Marker, Activiteit> MyMarkers;
    private Marker markerNewActiviteit;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Log.i("Permissions", "perm: " + checkPermissions());
        if (checkPermissions()) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME, MIN_DISTANCE, this);

        }
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        addButton();


    }

    private void addButton() {
        Button btnActiviteitAanmaken = new Button(this);
        btnActiviteitAanmaken.setBackgroundResource(R.drawable.add);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ToDP(50), ToDP(50), Gravity.RIGHT);
        params.setMargins(0, ToDP(10), ToDP(80), 0 );
        addContentView(btnActiviteitAanmaken, params);

        btnActiviteitAanmaken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (markerNewActiviteit == null){
                    markerNewActiviteit = mMap.addMarker(new MarkerOptions()
                            .position(mMap.getCameraPosition().target)
                            .draggable(true)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));

                }
            }

        });

        Button btnOpties = new Button(this);
        btnOpties.setBackgroundResource(R.drawable.ic_setting_light);
        params = new FrameLayout.LayoutParams(ToDP(50), ToDP(50), Gravity.RIGHT);
        params.setMargins(0, ToDP(10), ToDP(10), 0 );
        addContentView(btnOpties, params);

        btnOpties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private int ToDP(int pixels){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, pixels, getResources().getDisplayMetrics());
    }


    public boolean checkPermissions() {
        Boolean bReturnFine = false;
        Boolean bReturnCoarse = false;

        if (hasPermission(Manifest.permission.ACCESS_FINE_LOCATION)) {
            bReturnFine = true;
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }

        if (hasPermission(Manifest.permission.ACCESS_COARSE_LOCATION)) {
            bReturnCoarse = true;
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }

        if (bReturnCoarse && bReturnFine) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 0: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

                        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, this);

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.


                } else {
                    Log.e("Permission", "failed");
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            case 1: {
                if (grantResults.length > 0  && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, this);

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {
                    Log.e("Permission", "failed");

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.i("location", "onLocationChanged");
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        Log.i("onLocationChanged", "Latitude: " + location.getLatitude() + " Longitude: " + location.getLongitude());

        MyLocationMarker.remove();

        MyLocationMarker = mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title("You"));


        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, Zoom);
        mMap.animateCamera(cameraUpdate);
        if (checkPermissions()) {
            locationManager.removeUpdates(this);
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onProviderDisabled(String provider) {
    }


    private boolean hasPermission(String perm) {
        return (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this,
                perm));
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    private void GaNaarActiviteitBekijken(Activiteit MyActiviteit){
        Intent intent = new Intent(this, ActiviteitBekijken.class);
        intent.putExtra("activiteit", MyActiviteit);

        startActivity(intent);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        setMarkers();

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {


                Activiteit theActiviteit = MyMarkers.get(marker);
                GaNaarActiviteitBekijken(theActiviteit);

            }
        });


        mMap.setInfoWindowAdapter(new MyInfoWindowAdapter());

        Location MyLocation;
        LatLng latLng;
        CameraUpdate cameraUpdate;

        MyLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (MyLocation == null) {

            MyLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if (MyLocation != null) {
                //Netwerk locatie
                latLng = new LatLng(MyLocation.getLatitude(), MyLocation.getLongitude());
            }else{
                //Geen locatie beschikbaar -> Coordinaten van HU
                latLng = new LatLng(52.103472, 5.105896);
            }
        } else {
            //GPS Locatie
            latLng = new LatLng(MyLocation.getLatitude(), MyLocation.getLongitude());
        }

        MyLocationMarker = mMap.addMarker(new MarkerOptions().position(latLng).title("You"));
        cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, Zoom);
        mMap.animateCamera(cameraUpdate);
    }

    private void setMarkers(){
        ArrayList<Activiteit> Activiteiten = DAOFacade.getInstance().getMyActiviteitDAO().getAllActivities();
        MyMarkers = new HashMap<Marker, Activiteit>();
        Activiteit MyActiviteit;
        Marker MyMarker;

        for (int i = 0; i < Activiteiten.size(); i++) {
            MyActiviteit = Activiteiten.get(i);

            MyMarker =  mMap.addMarker(new MarkerOptions()
                    .position(MyActiviteit.getLocatie().getLatLng())
                    .title(MyActiviteit.getTitel())
                    .snippet(MyActiviteit.getMarkerText())
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.bal)));

            //Julien: Hier kan je de points aanpassen

            MyMarkers.put(MyMarker, MyActiviteit);


        }
    }



    }
