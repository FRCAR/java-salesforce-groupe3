package entrainement;

import java.security.KeyStore.Entry;
import java.util.Map;
import java.util.TreeMap;

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

        System.out.println("Liste de toutes les arènes :");
        for (EnumArene arena : EnumArene.values()) {
            System.out.println(" - " + arena);
        }
    }

    public void afficheAllPokeParOdre() {

    }

    

    public static void main(String[] args) {
        Referentiel monPokedex = new Referentiel();
        monPokedex.RecupAllPoke(poke);
        monPokedex.RecupAllPokeParOrdre(mesPokes);
        monPokedex.RecupAllPokeParOrdre(mesPokesInv);
        monPokedex.afficheDetailPoke(3);
        afficheAllArene();
        
    }

}