package entrainement;
public class Arene {
    private final EnumArene nom;
    private final int effetUnique;
    private final int effetPermanent;

    public Arene(EnumArene nom, int effetUnique, int effetPermanent){
        this.nom = nom;
        this.effetUnique = effetUnique;
        this.effetPermanent = effetPermanent;
    }
  
    public int getEffetUnique() {
        return effetUnique;
    }
    public int getEffetPermanent() {
        return effetPermanent;
    }

}
