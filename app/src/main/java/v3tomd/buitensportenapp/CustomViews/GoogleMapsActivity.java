package v3tomd.buitensportenapp.CustomViews;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import v3tomd.buitensportenapp.Database.DAO.ActiviteitDAO;
import v3tomd.buitensportenapp.Model.Activiteit;
import v3tomd.buitensportenapp.R;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
public class GoogleMapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private LocationManager locationManager;
    private static final long MIN_TIME = 5000;
    private static final float MIN_DISTANCE = 20;
    private static final float Zoom = 15;
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
        if (checkPermissions()) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, this);
        }
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public boolean checkPermissions() {
        Boolean bReturnFine = false;
        Boolean bReturnCoarse = false;
        if (hasPermission(Manifest.permission.ACCESS_FINE_LOCATION)) {
            bReturnFine = true;
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1);
        }
        if (hasPermission(Manifest.permission.ACCESS_COARSE_LOCATION)) {
            bReturnCoarse = true;
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    1);
        }

        if (bReturnCoarse && bReturnFine) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 0: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

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
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

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
        mMap.addMarker(new MarkerOptions().position(latLng).title("You"));
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng,Zoom);
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

    @TargetApi(Build.VERSION_CODES.M)
    private boolean hasPermission(String perm) {
        return (PackageManager.PERMISSION_GRANTED == checkSelfPermission(perm));
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Location MyLocation;


        MyLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (MyLocation == null) {

            MyLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if (MyLocation != null) {
                Log.i("onLocationChanged", "Latitude: " + MyLocation.getLatitude() + " Longitude: " + MyLocation.getLongitude());
                LatLng latLng = new LatLng(MyLocation.getLatitude(), MyLocation.getLongitude());
                mMap.addMarker(new MarkerOptions().position(latLng).title("You"));
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, Zoom);
            }
        } else {
            Log.i("onLocationChanged", "Latitude: " + MyLocation.getLatitude() + " Longitude: " + MyLocation.getLongitude());
            LatLng latLng = new LatLng(MyLocation.getLatitude(), MyLocation.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title("You"));
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng,Zoom);
        }

        setMarkers();


    }

    private void setMarkers(){
        ArrayList<Activiteit> Activiteiten = ActiviteitDAO.getInstance().getAlleActiviteiten();
        Activiteit MyActiviteit;

        for (int i = 0; i < Activiteiten.size(); i++) {
            MyActiviteit = Activiteiten.get(i);

            mMap.addMarker(new MarkerOptions().position(MyActiviteit.getLocatie().getLatLng()).title(MyActiviteit.getTitel()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

            //Julien: Hier kan je de points aanpassen


        }
    }


}
