package entrainement;
public class Arene {
    private final String nom;
    private final int effetUnique;
    private final int effetPermanent;

    public Arene(String nom, int effetUnique, int effetPermanent){
        this.nom = nom;
        this.effetUnique = effetUnique;
        this.effetPermanent = effetPermanent;
    }
    public String getNom() {
        return nom;
    }
    public int getEffetUnique() {
        return effetUnique;
    }
    public int getEffetPermanent() {
        return effetPermanent;
    }

}
