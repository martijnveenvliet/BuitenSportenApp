package v3tomd.buitensportenapp.Model;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

/**
 * Created by Martijn on 22-3-2016.
 */
public class Locatie implements Serializable {

    private double MyLatitude;
    private double MyLongitude;
    private int myID;

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

    public int getMyID() {
        return myID;
    }

    public LatLng getLatLng(){
        return new LatLng(MyLatitude, MyLongitude);
    }

}
