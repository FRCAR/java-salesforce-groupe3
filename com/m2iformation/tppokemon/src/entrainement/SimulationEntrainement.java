package entrainement;

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
    private static Espece monPoke;
    private Referentiel monPokedex;
    static Referentiel newPokedex = new Referentiel();

    public static void afficheAllArene() {
        System.out.println("");
        for (EnumArene arena : EnumArene.values()) {
            System.out.println(" - " + arena);
        }
    }

    public void afficheAllPoke() {

        for (Espece entrees : this.monPokedex.recupAllPoke()) {
            System.out.println("Mon id est " + entrees.getPokeId() + " je suis"
                    + entrees.getSurnom() + ", un "
                    + entrees.getEspece() + "\n");
        }
        System.out.println("************************");
    }

    public void afficheAllPokeParOrdre() {
        for (Espece entrees : this.monPokedex.recupAllPokeParOrdre()) {
            System.out.println("Mon XP est " + entrees.getPointsXp() + " je suis"
                    + entrees.getSurnom() + ", un "
                    + entrees.getEspece() + "\n");
        }
        System.out.println("************************");
    }

    public static Espece recupPokeParId(Integer id) {
        for (Espece entrees : newPokedex.recupAllPoke()) {
            if (id == entrees.getPokeId()) {
                // return this.map.get(id);
                System.out.println("Mon index est " + entrees.getPokeId() + " je suis " + entrees.getSurnom());
                Espece monPoke = entrees;
            }
        }
        return monPoke;
    }

    public void afficheDetailPoke(Integer id) {
        for (Espece entrees : this.monPokedex.recupAllPoke()) {
            if (id == entrees.getPokeId()) {
                // return this.map.get(id);
                System.out.println("Mon id est " + entrees.getPokeId() + " je suis " + entrees.getSurnom()
                        + ", mon espece est " + entrees.getEspece()
                        + " mon Type est : " + entrees.getType() + " , mes points de vie max sont de : "
                        + entrees.getPointsDeVieMax() + " et mon XP est de : "
                        + entrees.getPointsXp());
            }
        }
        System.out.println("\n ************************");
    }

    public static void main(String[] args) throws Exception {
        SimulationEntrainement monEntrainement = new SimulationEntrainement();
        monEntrainement.monPokedex = new Referentiel();
        Combat combat = new Combat();
        // Fonction pour choix aléatoire des combattants
        
        // commencement du combat
        // combat.startCombat(EnumArene.VOLCAN);
        // initialisation des points de vie
        // combat.initialisationPointsDeVie();
        // commencement du combat

        // Pour récup les pokémons par ordre exp et en ordre croissant
        // monPokedex.RecupAllPokeParOrdre(mesPokes);

        // *************************** DEBUT SCANNER *******************************
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
            int saisieNext = 0;
            // soulever l'exception si on tape autre chose que des chiffres
            try {
                premiereSaisieUser = scannerClavier1.nextInt();
            } catch (Exception e) {
                scannerClavier1.next();
                System.out.println("je t'ai catché ! incorrect");
                // continue; // no need here1
            }

            switch (premiereSaisieUser) {
                case 1 -> {
                    System.out.println("\n ************************");
                    System.out.println("Voila tous les identifiants et noms d'un pokémon : \n");
                    // Ici j'affiche les Id et les noms des pokémons
                    // monPokedex.RecupAllPoke(poke);
                    monEntrainement.afficheAllPoke();

                }
                case 2 -> {
                    System.out.println("\n ************************\n");
                    System.out.println("Voila la liste d'un pokémon, trié par expérience par odre décroissante : \n");
                    // ici j'affiche la liste d'un pokémon, trié par expérience (ordre décroissante)
                    // du plus fort au moins fort)
                    monEntrainement.afficheAllPokeParOrdre();
                }
                case 3 -> {
                    System.out.println("\n ************************");
                    System.out.println("Saisie moi l'id du pokémon que tu veux voir afficher :");
                    saisieNext = scannerClavier1.nextInt();
                    // ici j'affiche le pokemon que l'utilisateur veut afficher
                    monEntrainement.afficheDetailPoke(saisieNext);
                }
                case 4 -> {
                    System.out.println("\n ************************");
                    System.out.println("Voila la liste de toutes les arènes : ");
                    // ici j'affiche la liste de toutes les arènes
                    afficheAllArene();
                    System.out.println("\n ************************");
                }
                case 5 -> {
                    combat.shufflePoke(monEntrainement.monPokedex.recupAllPoke().stream().toArray(), 4);
                    combat.initialisationPointsDeVie();
                    // System.out
                    // .println(
                    // "Combart sur quel arène ? : \n Taper 1 - PRAIRIE \n Taper 2 - VOLCAN \n Taper
                    // 3 - MARE ACIDE : ");
                    // Integer saisieArene = scannerClavier1.nextInt();
                    // if (saisieArene == 1) {
                    // Arene prairie = new Arene(EnumArene.PRAIRIE, 0, 0);
                    // combat.startCombat(prairie);

                    // System.out.println();
                    // } else if (saisieArene == 2) {
                    // Arene volcan = new Arene(EnumArene.VOLCAN, 20, 0);
                    // combat.startCombat(volcan);

                    // System.out.println();
                    // } else if (saisieArene == 3) {
                    // Arene mareAcide = new Arene(EnumArene.MARE_ACIDE, 0, 5);
                    // combat.startCombat(mareAcide);

                    // System.out.println();
                    // } else {
                    // System.out.println("L'arene saisie n'est pas valide");
                    // }

                    String saisieArene = scannerClavier1.nextLine().toUpperCase().trim();
                    while (!saisieArene.matches("(?i)(prairie|volcan|\\bmare acide\\b)")) {
                        System.out.println("Combat sur quel arène ? (PRAIRIE, VOLCAN, MARE ACIDE) : ");
                        saisieArene = scannerClavier1.nextLine().toUpperCase().trim();
                        if (saisieArene.equals("PRAIRIE") || saisieArene.equals("prairie")
                                || saisieArene.equals("Prairie")) {
                            Arene prairie = new Arene(EnumArene.PRAIRIE, 0, 0);
                            System.out.println("\n ************************");
                            combat.startCombat(prairie);
                        } else if (saisieArene.equals("VOLCAN") || saisieArene.equals("volcan")
                                || saisieArene.equals("Volcan")) {
                            Arene volcan = new Arene(EnumArene.VOLCAN, 20, 0);
                            System.out.println("\n ************************");
                            combat.startCombat(volcan);
                        } else if (saisieArene.equalsIgnoreCase("MARE ACIDE")
                                || saisieArene.equalsIgnoreCase("mare acide")) {
                            Arene mareAcide = new Arene(EnumArene.MARE_ACIDE, 0, 5);
                            System.out.println("\n ************************");
                            combat.startCombat(mareAcide);
                        } else {
                            System.out.println("L'arène saisie n'est pas valide.");
                        }
                    }
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
        // *************************** FIN SCANNER *******************************

    }

}
