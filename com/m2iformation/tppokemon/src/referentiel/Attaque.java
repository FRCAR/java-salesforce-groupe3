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

        if (pokemonAttaquant.EnumType == EnumType.EAU) {
            if (pokemonDefenseur.EnumType == EnumType.FEU) {
                multiplicateur *= 1.25;
            }
        } else if (pokemonAttaquant.EnumType == EnumType.FEU) {
            if (pokemonDefenseur.EnumType == EnumType.VOL) {
                multiplicateur *= 1;
            }
        } else if (pokemonAttaquant.EnumType == EnumType.VOL) {
            if (pokemonDefenseur.EnumType == EnumType.SOL) {
                multiplicateur *= 0.75;
            }
        } else if (pokemonAttaquant.EnumType == EnumType.SOL) {
            if (pokemonDefenseur.EnumType == EnumType.EAU) {
                multiplicateur *= 1;
            }
        }

        if (pokemonAttaquant.EnumType == attaqueDefenseur) {
            multiplicateur *= 1;
        }

        int degats = (int) Math.round(attaque.getDegats() * multiplicateur);
        return degats;
    }

}