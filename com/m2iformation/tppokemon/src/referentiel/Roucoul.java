package referentiel;

public class Roucoul extends Espece{
    public Roucoul(double pokeId, String surnom, String espece, EnumType type, int pointsDeVieMax){
        this.pokeId = pokeId;
        this.surnom =  surnom;
        this.espece = espece;
        this.type = type;
        this.pointsDeVieMax = pointsDeVieMax;
    }

    @Override
    public double getPokeId() {
        return pokeId;
    }

    @Override
    public String getSurnom() {
        return surnom;
    }

    @Override
    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    @Override
    public String getEspece() {
        return espece;
    }

    @Override
    public EnumType getType() {
        return type;
    }

    @Override
    public int getPointsDeVie() {
        return pointsDeVie;
    }

    @Override
    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    @Override
    public int getPointsDeVieMax() {
        return pointsDeVieMax;
    }

    @Override
    public int getPointsXp() {
        return pointsXp;
    }

    @Override
    public void setPointsXp(int pointsXp) {
        this.pointsXp = pointsXp;
    }
}
