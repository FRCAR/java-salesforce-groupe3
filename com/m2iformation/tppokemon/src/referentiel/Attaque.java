package referentiel;

import java.lang.ProcessBuilder.Redirect.Type;

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

    public int calculDegats(Espece pokemonAttaquant, Espece pokemonDefenseur, Attaque attaque) {
        double multiplicateur = 1.0;
        Attaque attaque_feu = new Attaque("flameche", 20);
        Attaque attaque_eau = new Attaque("plouf", 20);
        Attaque attaque_air = new Attaque("battements", 23);
        Attaque attaque_sol = new Attaque("ecrasement", 18);

        if (pokemonAttaquant.getType() == EnumType.EAU) {
            if (pokemonDefenseur.getType() == EnumType.FEU) {
                multiplicateur *= 1.25;
            }
        } else if (pokemonAttaquant.getType() == EnumType.FEU) {
            if (pokemonDefenseur.getType() == EnumType.VOL) {
                multiplicateur *= 1;
            }
        } else if (pokemonAttaquant.getType() == EnumType.VOL) {
            if (pokemonDefenseur.getType() == EnumType.SOL) {
                multiplicateur *= 0.75;
            }
        } else if (pokemonAttaquant.getType() == EnumType.SOL) {
            if (pokemonDefenseur.getType() == EnumType.EAU) {
                multiplicateur *= 1;
            }
        }

        if (pokemonAttaquant.getType() == pokemonDefenseur.getType()) {
            multiplicateur *= 1;
        }

        int degats = (int) Math.round(attaque.getDegats() * multiplicateur);
        return degats;
    }

}