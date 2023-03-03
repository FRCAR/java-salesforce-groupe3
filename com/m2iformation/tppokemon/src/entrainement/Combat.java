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
        // System.out.println("pokemon 1 :" + objects[0].toString());
        // System.out.println("pokemon 2 :" + objects[1].toString());
        pokemon1 = (Espece) objects[0];
        pokemon2 = (Espece) objects[1];
    }

    public Object[] recupCombattants() {
        Object[] poke = { pokemon1, pokemon2 };
        
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
        Object[] mesCombattants = this.recupCombattants();
        while (((Espece) mesCombattants[0]).getPointsDeVie() >= 0 && ((Espece) mesCombattants[1]).getPointsDeVie() >= 0) {
            if (((Espece) mesCombattants[0]).getPointsDeVie() == 0 || ((Espece) mesCombattants[1]).getPointsDeVie() == 0) {
                if (((Espece) mesCombattants[0]).getPointsDeVie() == 0) {
                    System.out.println(((Espece) mesCombattants[0]).toString() + " est ko ! "
                            + ((Espece) mesCombattants[1]).toString() + " l'importe ! ");
                    break;
                } else {
                    System.out.println(((Espece) mesCombattants[1]).toString() + " est ko ! "
                            + ((Espece) mesCombattants[0]).toString() + " l'importe ! ");
                    break;
                }
            } else if (compteur == 0 && EnumArene.VOLCAN == arene.getNom()) {
                ((Espece) mesCombattants[0]).setPointsDeVie(((Espece) mesCombattants[0]).getPointsDeVie() - arene.getEffetUnique());
                ((Espece) mesCombattants[1]).setPointsDeVie(((Espece) mesCombattants[1]).getPointsDeVie() - arene.getEffetUnique());
                System.out.println("L'effet unique de l'arene " + arene.getNom() + " s'applique ! ");
                System.out.println("Les points de vie de " + ((Espece) mesCombattants[0]).getSurnom()
                        + " sont de " + ((Espece) mesCombattants[0]).getPointsDeVie());
                System.out.println("Les points de vie de " + ((Espece) mesCombattants[1]).getSurnom()
                        + " sont de " + ((Espece) mesCombattants[1]).getPointsDeVie());
                System.out.println(((Espece) mesCombattants[0]) + " attaque en premier !");
                        this.attaque();
            } else if (compteur >= 0 && EnumArene.PRAIRIE == arene.getNom()) {
                System.out.println("L'arène " + arene.getNom() + " n'a pas d'effet");
                System.out.println(((Espece) mesCombattants[0]) + " attaque en premier !");
                this.attaque();
            } else if (compteur > 0 && arene.getNom() == EnumArene.VOLCAN) {
                System.out.println("L'arène " + arene.getNom() + " n'a pas d'effet permanent");
                System.out.println(((Espece) mesCombattants[0]) + " attaque en premier !");
                this.attaque();
            } else if (compteur >= 0 && EnumArene.MARE_ACIDE == arene.getNom()) {
              
                ((Espece) mesCombattants[0]).setPointsDeVie(((Espece) mesCombattants[0]).getPointsDeVie() - arene.getEffetPermanent());
                ((Espece) mesCombattants[1]).setPointsDeVie(((Espece) mesCombattants[1]).getPointsDeVie() - arene.getEffetPermanent());
                System.out.println("L'effet permanent de l'arene " + arene.getNom() + " s'applique ! ");
                System.out.println("Les points de vie de " + ((Espece) mesCombattants[0]).getSurnom()
                        + " sont de " + ((Espece) mesCombattants[0]).getPointsDeVie());
                System.out.println("Les points de vie de " + ((Espece) mesCombattants[1]).getSurnom()
                        + " sont de " + ((Espece) mesCombattants[1]).getPointsDeVie());
                System.out.println(((Espece) mesCombattants[0]) + " attaque en premier !");
                this.attaque();
                        
            }
            compteur++;
        }
    }

    public void attaque() {
        // définir type d'attaque par pokemon
        Attaque attaque = new Attaque(null, 0);
        Object[] mesCombattants = this.recupCombattants();
       
        // while (((Espece) mesCombattants[0]).getPointsDeVie() >= 0 && ((Espece) mesCombattants[1]).getPointsDeVie() >= 0){
            
            this.shufflePoke(mesCombattants, 2);
            // if(((Espece) mesCombattants[0]).getPointsDeVie() == 0 || ((Espece) mesCombattants[1]).getPointsDeVie() == 0){    
            // if (((Espece) mesCombattants[0]).getPointsDeVie() <= 0) {
            //         System.out.println(((Espece) mesCombattants[0]).toString() + " est ko ! " + ((Espece) mesCombattants[1]).toString() + " l'importe ! ");
            //         break;
            //     } else if (((Espece) mesCombattants[1]).getPointsDeVie() <= 0) {
            //         System.out.println(
            //                 ((Espece) mesCombattants[1]) + " est ko ! " + ((Espece) mesCombattants[0]).toString() + " l'importe ! ");
            //         break;
            //     } 
            // } else {
            System.out.println(((Espece) mesCombattants[0]).toString() + " attaque :");
            if (((Espece) mesCombattants[0]).getType() == EnumType.EAU || ((Espece) mesCombattants[1]).getType() == EnumType.EAU) {
                attaque = attaque_eau;
            } else if (((Espece) mesCombattants[0]).getType() == EnumType.SOL || ((Espece) mesCombattants[1]).getType() == EnumType.SOL) {
                attaque = attaque_sol;
            } else if (((Espece) mesCombattants[0]).getType() == EnumType.VOL || ((Espece) mesCombattants[1]).getType() == EnumType.VOL) {
                attaque = attaque_air;
            } else if (((Espece) mesCombattants[0]).getType() == EnumType.FEU || ((Espece) mesCombattants[1]).getType() == EnumType.FEU) {
                attaque = attaque_feu;
            }
            int calculDegats = (int) (attaque.getDegats() * attaque.calculDegats(pokemon1, pokemon2));
            ((Espece) mesCombattants[1]).setPointsDeVie(((Espece) mesCombattants[1]).getPointsDeVie() - calculDegats);
           
            System.out
                    .println( ((Espece) mesCombattants[1]).toString() + " a perdu " + calculDegats + "pts de vie. il lui reste:" + ((Espece) mesCombattants[1]).getPointsDeVie());
            // }  
            ((Espece) mesCombattants[0]).setPointsXp(100 + ((Espece) mesCombattants[1]).getPointsXp());
            System.out.println(((Espece) mesCombattants[0]) + " a gagné : "
                    + ((Espece) mesCombattants[0]).getPointsXp() + " point de xp!");
        }
     
    // }
   

        //     System.out.println("start: pokemon2 attaque:");
        //     int calculDegats2 = attaque.getDegats() * attaque.calculDegats(pokemon2, pokemon1);
        //     pokemon2.setPointsDeVie(ptsVie1 - calculDegats2);
        //     System.out
        //             .println("poke1 a perdu " + calculDegats + "pts de vie. il lui reste:" + pokemon1.getPointsDeVie());
        // } ;
    

    public void update() {

    }
}
