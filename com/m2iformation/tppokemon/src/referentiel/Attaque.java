package referentiel;

public class Attaque {

    private final String nom;
    private int degats;

    // CONSTRUCTEUR
    public Attaque(String nom) {
        this.nom = nom;
    }

    // GETTERS SETTERS
    public String getNom() {
        return nom;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    // public int calculDegats() {
    // }

}