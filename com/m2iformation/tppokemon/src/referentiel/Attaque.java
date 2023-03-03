package referentiel;

public class Attaque {

    private final String nom;
    private int degats;

    public Attaque(String nom, int degats) {
        this.nom = nom;
        this.degats = degats;
    }

    public String getNom() {
        return nom;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public int calculDegats(Espece pokemonAttaquant, Espece pokemonDefenseur) {
        double multiplicateur = 1.0;

        if ((pokemonAttaquant.getType() == EnumType.EAU) && (pokemonDefenseur.getType() == EnumType.EAU)
                || (pokemonAttaquant.getType() == EnumType.EAU) && (pokemonDefenseur.getType() == EnumType.SOL)
                || (pokemonAttaquant
                        .getType() == EnumType.AIR) && (pokemonDefenseur.getType() == EnumType.AIR)
                || (pokemonAttaquant
                        .getType() == EnumType.AIR) && (pokemonDefenseur.getType() == EnumType.FEU)
                || (pokemonAttaquant.getType() == EnumType.SOL) && (pokemonDefenseur.getType() == EnumType.EAU)
                || (pokemonAttaquant
                        .getType() == EnumType.SOL) && (pokemonDefenseur.getType() == EnumType.SOL)
                || (pokemonAttaquant.getType() == EnumType.FEU) && (pokemonDefenseur.getType() == EnumType.FEU)
                || (pokemonAttaquant
                        .getType() == EnumType.FEU) && (pokemonDefenseur.getType() == EnumType.AIR)) {

            multiplicateur *= 1;
        } else if ((pokemonAttaquant.getType() == EnumType.FEU && pokemonDefenseur.getType() == EnumType.EAU)
                || (pokemonAttaquant.getType() == EnumType.EAU && pokemonDefenseur.getType() == EnumType.AIR)
                || (pokemonAttaquant.getType() == EnumType.AIR && pokemonDefenseur.getType() == EnumType.SOL)
                || (pokemonAttaquant.getType() == EnumType.SOL && pokemonDefenseur.getType() == EnumType.FEU)) {
            multiplicateur *= 0.75;
        } else if ((pokemonAttaquant.getType() == EnumType.AIR && pokemonDefenseur.getType() == EnumType.EAU)
                || (pokemonAttaquant.getType() == EnumType.EAU && pokemonDefenseur.getType() == EnumType.FEU)
                || (pokemonAttaquant.getType() == EnumType.SOL && pokemonDefenseur.getType() == EnumType.AIR)
                || (pokemonAttaquant.getType() == EnumType.FEU && pokemonDefenseur.getType() == EnumType.SOL)) {
            multiplicateur *= 1.25;
        }

        int degats = (int) Math.round(multiplicateur);
        return degats;
    }

}