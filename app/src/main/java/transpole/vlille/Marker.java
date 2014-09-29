package transpole.vlille;

/**
 * Created by tomtom on 9/21/14.
 */
public class Marker {

    private int id;
    private double lat;
    private double lng;
    private String name;
    private String adress;
    private int status;
    private int bikes;
    private int attachs;
    private String paiement;
    private String lastupd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBikes() {
        return bikes;
    }

    public void setBikes(int bikes) {
        this.bikes = bikes;
    }

    public int getAttachs() {
        return attachs;
    }

    public void setAttachs(int attachs) {
        this.attachs = attachs;
    }

    public String getPaiement() {
        return paiement;
    }

    public void setPaiement(String paiement) {
        this.paiement = paiement;
    }

    public String getLastupd() {
        return lastupd;
    }

    public void setLastupd(String lastupd) {
        this.lastupd = lastupd;
    }

    @Override
    public String toString() {
        return "Marker{" +
                "id=" + id +
                ", lat=" + lat +
                ", lng=" + lng +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", status=" + status +
                ", bikes=" + bikes +
                ", attachs=" + attachs +
                ", paiement='" + paiement + '\'' +
                ", lastupd='" + lastupd + '\'' +
                '}';
    }
}
