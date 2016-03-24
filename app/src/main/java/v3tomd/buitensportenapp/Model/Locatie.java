package v3tomd.buitensportenapp.Model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Martijn on 22-3-2016.
 */
public class Locatie {

    private double MyLatitude;
    private double MyLongitude;

    public Locatie(double Latitude, double Longitude) {
        MyLatitude = Latitude;
        MyLongitude = Longitude;
    }

    public double getLatitude() {
        return MyLatitude;
    }

    public void setLatitude(double myLatitude) {
        MyLatitude = myLatitude;
    }
    public double getLongitude() {
        return MyLongitude;
    }

    public void setLongitude(double myLongitude) {
        MyLongitude = myLongitude;
    }


    public LatLng getLatLng(){
        return new LatLng(MyLatitude, MyLongitude);
    }

}
