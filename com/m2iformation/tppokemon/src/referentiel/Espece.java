package referentiel;

abstract public class Espece {
    protected Integer pokeId;
    protected String surnom;
    protected String espece;
    protected EnumType type;
    protected int pointsDeVie;
    protected int pointsDeVieMax;
    protected int pointsXp;

    abstract public Integer getPokeId();

    public String getSurnom() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSurnom'");
    }

    abstract public void setSurnom(String surnom);

    abstract public String getEspece();

    abstract public EnumType getType();

    abstract public int getPointsDeVie();

    abstract public void setPointsDeVie(int pointsDeVie);

    abstract public int getPointsDeVieMax();

    abstract public int getPointsXp();

    abstract public void setPointsXp(int pointsXp);

    @Override
    public String toString() {
        return " " +surnom +" : un " +espece+ "";
        // return "Espece [pokeId=" + pokeId + ", surnom=" + surnom + ", espece=" + espece + ", type=" + type
        //         + ", pointsDeVie=" + pointsDeVie + ", pointsDeVieMax=" + pointsDeVieMax + ", pointsXp=" + pointsXp
        //         + "]";
    }

}
