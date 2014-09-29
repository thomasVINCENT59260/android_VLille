package transpole.vlille;

import java.util.ArrayList;

/**
 * Created by tomtom on 9/21/14.
 */
public class Markers {

    private double center_lat;
    private double center_lng;
    private int zoom_level;
    private ArrayList<Marker> marker=new ArrayList<Marker>();

    public double getCenter_lat() {
        return center_lat;
    }

    public double getCenter_lng() {
        return center_lng;
    }

    public int getZoom_level() {
        return zoom_level;
    }

    public ArrayList<Marker> getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker.add(marker);
    }

    public void setCenter_lat(double center_lat){
        this.center_lat=center_lat;
    }

    public void setCenter_lng(double center_lng){
        this.center_lng=center_lng;
    }

    public void setZoom_level(int zoom_level){
        this.zoom_level=zoom_level;
    }

    @Override
    public String toString() {
        return "Markers{" +
                "center_lat=" + center_lat +
                ", center_lng=" + center_lng +
                ", zoom_level=" + zoom_level +
                ", marker=" + marker +
                '}';
    }
}
