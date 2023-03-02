package entrainement;

import java.security.KeyStore.Entry;
import java.util.Map;
import java.util.Scanner;

import referentiel.Carapuce;
import referentiel.Espece;
import referentiel.Racaillou;
import referentiel.Referentiel;
import referentiel.Roucoul;
import referentiel.Salameche;

public class SimulationEntrainement {
    private Salameche monSalameche;
    private Roucoul monRoucoul;
    private Carapuce monCarapuce;
    private Racaillou monRacaillou;
    private Arene monArene;
    private Combat monCombat;
    private static Referentiel monPokedex;
    private static Map<Integer, Espece> poke = Referentiel.getMap();
    private static Map<Integer, Espece> mesPokes = Referentiel.getPokeOrdonne();
    private static Map<Integer, Espece> mesPokesInv = Referentiel.getPokeOrdonneInv();

    public static void afficheAllArene() {
        for (EnumArene arena : EnumArene.values()) {
            System.out.println(" - " + arena);
        }
    }

    public void afficheAllPokeParOdre() {

    }

    public static void main(String[] args) throws Exception {
        Referentiel monPokedex = new Referentiel();

        // Pour récup les pokémons par ordre exp et en ordre croissant
        // monPokedex.RecupAllPokeParOrdre(mesPokes);

        // ********** DEBUT SCANNER **********
        // Je mets ici un boolean a true pour qu'il puisse changer d'état lorsqu'on
        // clique sur "6 - fermer le terminal"
        boolean bool = true;
        Scanner scannerClavier1 = new Scanner(System.in);
        while (bool) {

            System.out.println("Taper 1 - afficher tous les identifiants et noms d'un pokémon");
            System.out.println("Taper 2 - afficher la liste d'un pokémon, trié par expérience par odre décroissante");
            System.out.println("Taper 3 - afficher le détail d'un pokémon");
            System.out.println("Taper 4 - afficher la liste de toutes les arènes");
            System.out.println("Taper 5 - Faire combatre deux pokémons");
            System.out.println("Taper 6 - Fermer le terminal");

            // variable initialisé pour qu'il puisse être utilisé dans le switch
            int premiereSaisieUser = 0;
            // soulever l'exception si on tape autre chose que des chiffres
            try {
                premiereSaisieUser = scannerClavier1.nextInt();
            } catch (Exception e) {
                scannerClavier1.next();
                System.out.println("je t'ai catché ! incorrect");
                // continue; // no need here
            }

            switch (premiereSaisieUser) {
                case 1 -> {
                    System.out.println("Voila tous les identifiants et noms d'un pokémon : \n");
                    // Ici j'affiche les Id et les noms des pokémons
                    monPokedex.RecupAllPoke(poke);

                }
                case 2 -> {
                    System.out.println("Voila la liste d'un pokémon, trié par expérience par odre décroissante : \n");
                    // ici j'affiche la liste d'un pokémon, trié par expérience (ordre décroissante)
                    // du plus fort au moins fort)
                    monPokedex.RecupAllPokeParOrdre(mesPokesInv);
                }
                case 3 -> {
                    System.out.println("Saisie moi l'id du pokémon que tu veux voir afficher :");
                    int saisieNext = scannerClavier1.nextInt();
                    // ici j'affiche le pokemon que l'utilisateur veut afficher
                    monPokedex.afficheDetailPoke(3);
                }
                case 4 -> {
                    System.out.println("Voila la liste de toutes les arènes : ");
                    // ici j'affiche la liste de toutes les arènes
                    afficheAllArene();
                    System.out.println("\n");
                }
                case 5 -> {
                    System.out.println("Saisie moi l'id de deux pokémons pour lequel tu veux voir combattre \n");
                    System.out.println("le premier id du pokémon : ");
                    int saisieIdPokemon1 = scannerClavier1.nextInt();
                    System.out.println("le deuxième id du pokémon : ");
                    int saisieIdPokemon2 = scannerClavier1.nextInt();

                    // System.out
                    // .println(
                    // "Combart sur quel arène ? : \n Taper 1 - PRAIRIE \n Taper 2 - VOLCAN \n
                    // Taper
                    // 3 - MARE ACIDE : ");
                    // Integer saisieArene = scannerClavier1.nextInt();

                    System.out
                            .println(
                                    "Combart sur quel arène ? (PRAIRIE, VOLCAN, MARE ACIDE) : ");
                    String saisieArene = scannerClavier1.nextLine();
                    // Ici Le combat va commencer
                }
                case 6 -> {
                    System.out.println("Au revoir, à bientot ! ...et le terminal se ferme");
                    bool = false;

                }
                default -> {
                    System.out.println("Désolé, je n'ai pas compris ta saisie \n");
                }
            } // Fin du switch case

        } // fin du While()

        scannerClavier1.close();
        // ********** FIN SCANNER **********
    }

}
