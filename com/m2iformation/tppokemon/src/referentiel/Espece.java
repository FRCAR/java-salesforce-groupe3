package referentiel;

abstract public class Espece {
    protected double pokeId;
    protected String surnom;
    protected String espece;
    protected EnumType type;
    protected int pointsDeVie;
    protected int pointsDeVieMax;
    protected int pointsXp;

    abstract public double getPokeId();

    abstract public String getSurnom();

    abstract public void setSurnom(String surnom);

    abstract public String getEspece();

    abstract public EnumType getType();

    abstract public int getPointsDeVie();

    abstract public void setPointsDeVie(int pointsDeVie);

    abstract public int getPointsDeVieMax();

    abstract public int getPointsXp();

    abstract public void setPointsXp(int pointsXp);

}
