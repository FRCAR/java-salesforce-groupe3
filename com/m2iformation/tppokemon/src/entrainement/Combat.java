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
import referentiel.Referentiel;

public class Combat {
    private Espece pokemon1;
    private Espece pokemon2;

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

    public void startCombat(EnumArene nomArene) {
        System.out.println("Le combat dans " + nomArene + " entre " + pokemon1 + " et " + pokemon2 + " commence !");
    }

    public void attaque() {

    }

    public void update() {

    }
}
