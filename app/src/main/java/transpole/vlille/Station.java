package transpole.vlille;

/**
 * Created by tomtom on 9/19/14.
 */
public class Station {

    private String nom;
    private String addresse;
    private String commune;
    private int veloLibre;
    private int placeLibre;

    public Station(String nom, String addresse, String commune) {

        this.nom = nom;
        this.addresse = addresse;
        this.commune = commune;
    }

    public Station(String nom, String addresse, String commune, int veloLibre, int placeLibre) {

        this.nom = nom;
        this.addresse = addresse;
        this.commune = commune;
        this.veloLibre = veloLibre;
        this.placeLibre = placeLibre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public int getVeloLibre() {
        return veloLibre;
    }

    public void setVeloLibre(int veloLibre) {
        this.veloLibre = veloLibre;
    }

    public int getPlaceLibre() {
        return placeLibre;
    }

    public void setPlaceLibre(int placeLibre) {
        this.placeLibre = placeLibre;
    }
}
