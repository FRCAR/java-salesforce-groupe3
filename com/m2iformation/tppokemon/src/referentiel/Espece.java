package referentiel;

public class Espece {
    private int id;
    private String nom;
    private String type;
    private int pointsDeVieMax;
    private String attaque;

    public Espece(int id, String nom, String type, int pointsDeVieMax, String attaque) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.pointsDeVieMax = pointsDeVieMax;
        this.attaque = attaque;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPointsDeVieMax() {
        return pointsDeVieMax;
    }

    public void setPointsDeVieMax(int pointsDeVieMax) {
        this.pointsDeVieMax = pointsDeVieMax;
    }

    public String getAttaque() {
        return attaque;
    }

    public void setAttaque(String attaque) {
        this.attaque = attaque;
    }
}
