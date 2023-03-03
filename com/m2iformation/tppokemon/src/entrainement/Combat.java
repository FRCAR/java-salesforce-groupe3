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

    public Object[] recupCombattants() {
        Object[] poke = { pokemon1, pokemon2 };
        System.out.println(poke[0] + " attaque en premier !");
        return poke;
    }

    public void initialisationPointsDeVie() {
        pokemon1.setPointsDeVie(pokemon1.getPointsDeVieMax());
        pokemon2.setPointsDeVie(pokemon2.getPointsDeVieMax());
        System.out.println("Les points de vie de " + pokemon1.toString() + "sont de " + pokemon1.getPointsDeVie()
                + "Les points de vie de " + pokemon2.toString() + " sont de " + pokemon2.getPointsDeVie() + ".");

    }

    public void startCombat(Arene arene) {
        System.out
                .println("Le combat dans " + arene.getNom() + " entre " + pokemon1 + " et " + pokemon2
                        + " commence !");

        int compteur = 0;

        while (pokemon1.getPointsDeVie() >= 0 && pokemon2.getPointsDeVie() >= 0) {
            Object[] mesCombattants = this.recupCombattants();
            this.shufflePoke(mesCombattants, 2);
            if (pokemon1.getPointsDeVie() == 0 || pokemon2.getPointsDeVie() == 0) {
                if (pokemon1.getPointsDeVie() == 0) {
                    System.out.println(pokemon1.toString() + " est ko ! " + pokemon2.toString() + " l'importe ! ");
                    break;
                } else {
                    System.out.println(pokemon2.toString() + " est ko ! " + pokemon1.toString() + " l'importe ! ");
                    break;
                }
            } else if (compteur == 0 && EnumArene.VOLCAN == arene.getNom()) {
                pokemon1.setPointsDeVie(pokemon1.getPointsDeVie() - arene.getEffetUnique());
                pokemon2.setPointsDeVie(pokemon2.getPointsDeVie() - arene.getEffetUnique());
                System.out.println("L'effet unique de l'arene " + arene.getNom() + " s'applique ! ");
                System.out.println("Les points de vie de " + pokemon1.getSurnom()
                        + " sont de " + pokemon1.getPointsDeVie());
                System.out.println("Les points de vie de " + pokemon2.getSurnom()
                        + " sont de " + pokemon2.getPointsDeVie());
            } else if (compteur >= 0 && EnumArene.PRAIRIE == arene.getNom()) {
                System.out.println("L'arène " + arene.getNom() + " n'a pas d'effet");
            } else if (compteur > 0 && arene.getNom() == EnumArene.VOLCAN) {
                System.out.println("L'arène " + arene.getNom() + " n'a pas d'effet permanent");
            } else if (compteur >= 0 && EnumArene.MARE_ACIDE == arene.getNom()) {
                pokemon1.setPointsDeVie(pokemon1.getPointsDeVie() - arene.getEffetPermanent());
                pokemon2.setPointsDeVie(pokemon2.getPointsDeVie() - arene.getEffetPermanent());
                System.out.println("L'effet permanent de l'arene " + arene.getNom() + " s'applique ! ");
                System.out.println("Les points de vie de " + pokemon1.getSurnom()
                        + " sont de " + pokemon1.getPointsDeVie());
                System.out.println("Les points de vie de " + pokemon2.getSurnom()
                        + " sont de " + pokemon2.getPointsDeVie());
            }
            compteur++;
        }
    }

    public void attaque() {
        // définir type d'attaque par pokemon
        Attaque attaque = new Attaque(null, 0);
        if (pokemon1.getType() == EnumType.EAU || pokemon2.getType() == EnumType.EAU) {
            attaque = attaque_eau;
        } else if (pokemon1.getType() == EnumType.SOL || pokemon2.getType() == EnumType.SOL) {
            attaque = attaque_sol;
        } else if (pokemon1.getType() == EnumType.VOL || pokemon2.getType() == EnumType.VOL) {
            attaque = attaque_air;
        } else if (pokemon1.getType() == EnumType.FEU || pokemon2.getType() == EnumType.FEU) {
            attaque = attaque_feu;
        }
        double calculDegats = attaque.getDegats() * attaque.calculDegats(pokemon1, pokemon2);
        System.out.println("bonus attaque1: " + attaque.calculDegats(pokemon1, pokemon2));
        System.out.println("bonus attaque2: " + attaque.calculDegats(pokemon2, pokemon1));
        System.out.println("poke1:" + pokemon1.toString() + "son attaque est " + attaque.getNom() + " dégat attaque: "
                + attaque.getDegats());
        while (pokemon1.getPointsDeVie() >= 0 && pokemon2.getPointsDeVie() >= 0) {
            if (pokemon1.getPointsDeVie() == 0 || pokemon2.getPointsDeVie() == 0) {
                if (pokemon1.getPointsDeVie() == 0) {
                    System.out.println(pokemon1.toString() + " est ko ! " + pokemon2.toString() + " l'importe ! ");
                    pokemon2.setPointsXp((100 + pokemon1.getPointsXp()));
                    break;
                } else if (pokemon2.getPointsDeVie() == 0) {
                    System.out.println(pokemon2.toString() + " est ko ! " + pokemon1.toString() + " l'importe ! ");
                    pokemon1.setPointsXp((100 + pokemon2.getPointsXp()));
                    break;
                }
            } else {
                System.out.println(pokemon1.toString() + " attaque:");
                pokemon2.setPointsDeVie(pokemon2.getPointsDeVie() - (int) calculDegats);
                System.out
                        .println(pokemon2.toString() + " a perdu " + calculDegats + "pts de vie. il lui reste:"
                                + pokemon2.getPointsDeVie());
            }
        }

    }

    // System.out.println("start: pokemon2 attaque:");
    // int calculDegats2 = attaque.getDegats() * attaque.calculDegats(pokemon2,
    // pokemon1);
    // pokemon2.setPointsDeVie(ptsVie1 - calculDegats2);
    // System.out
    // .println("poke1 a perdu " + calculDegats + "pts de vie. il lui reste:" +
    // pokemon1.getPointsDeVie());
    // } ;

    public void update() {

    }
}
