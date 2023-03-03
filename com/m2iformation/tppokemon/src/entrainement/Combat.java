package entrainement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import referentiel.Espece;
import referentiel.Attaque;
import referentiel.EnumType;
import referentiel.Referentiel;

public class Combat {
    private Espece pokemon1;
    private Espece pokemon2;
    private Attaque attaque_feu = new Attaque("flameche", 20);
    private Attaque attaque_eau = new Attaque("plouf", 20);
    private Attaque attaque_air = new Attaque("battements", 23);
    private Attaque attaque_sol = new Attaque("ecrasement", 18);

    public void shufflePoke(Object[] objects, int n) {
        // Creating a object for Random class
        Random r = new Random();
        // Start from the last element and swap one by one. We don't
        // need to run for the first element that's why i > 0
        for (int i = n - 1; i > 0; i--) {
            // Pick a random index from 0 to i
            int j = r.nextInt(i + 1);
            // Swap arr[i] with the element at random index
            Object temp = objects[i];
            objects[i] = objects[j];
            objects[j] = temp;
        }
        // Prints the random pokemon
        System.out.println("pokemon 1 :" + objects[0].toString());
        System.out.println("pokemon 2 :" + objects[1].toString());
        pokemon1 = (Espece) objects[0];
        pokemon2 = (Espece) objects[1];
    }

    public void initialisationPointsDeVie() {
        pokemon1.setPointsDeVie(pokemon1.getPointsDeVieMax());
        pokemon2.setPointsDeVie(pokemon2.getPointsDeVieMax());
        System.out.println("Les points de vie de " + pokemon1.toString() + "sont de " + pokemon1.getPointsDeVie()
                + ". git"
                + "Les points de vie de " + pokemon2.toString() + " sont de " + pokemon2.getPointsDeVie() + ".");

    }

    public void startCombat(Enum nomArene) {
        System.out.println("Le combat dans " + nomArene + " entre " + pokemon1 + " et " + pokemon2 + " commence !");
    }

    public void attaque(Espece pokemon1, Espece pokemon2) {
        // définir type d'attaque par pokemon
        Attaque attaque = new Attaque(null, 0);
        int ptsVie1 = pokemon1.getPointsDeVie();
        int ptsVie2 = pokemon2.getPointsDeVie();
        if (pokemon1.getType() == EnumType.EAU || pokemon2.getType() == EnumType.EAU) {
            attaque = attaque_eau;
        } else if (pokemon1.getType() == EnumType.SOL || pokemon2.getType() == EnumType.SOL) {
            attaque = attaque_sol;
        } else if (pokemon1.getType() == EnumType.AIR || pokemon2.getType() == EnumType.AIR) {
            attaque = attaque_air;
        } else if (pokemon1.getType() == EnumType.FEU || pokemon2.getType() == EnumType.FEU) {
            attaque = attaque_feu;
        }
        do {
            System.out.println("start: pokemon1 attaque:");
            int calculDegats = attaque.getDegats() * attaque.calculDegats(pokemon1, pokemon2);
            pokemon2.setPointsDeVie(ptsVie2 - calculDegats);
            System.out
                    .println("poke2 a perdu " + calculDegats + "pts de vie. il lui reste:" + pokemon2.getPointsDeVie());
            System.out.println("start: pokemon2 attaque:");
            int calculDegats2 = attaque.getDegats() * attaque.calculDegats(pokemon2, pokemon1);
            pokemon2.setPointsDeVie(ptsVie1 - calculDegats2);
            System.out
                    .println("poke1 a perdu " + calculDegats + "pts de vie. il lui reste:" + pokemon1.getPointsDeVie());
        } while (pokemon1.getPointsDeVie() >= 0 || pokemon2.getPointsDeVie() >= 0);
    }

    public void update() {

    }
}
