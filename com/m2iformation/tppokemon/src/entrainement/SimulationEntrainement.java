package entrainement;

import java.util.Map;
import java.util.TreeMap;

import referentiel.Carapuce;
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
    private static Map<Double, String> map2 = monPokedex.getMap();

    public static void main(String[] args) {
       Referentiel monPokedex = new Referentiel();
        monPokedex.RecupAllPoke(map2);
    }

    public void afficheAllPokeParOdre() {
        // Map<Integer, Object> mapTri = new TreeMap<Integer, Object>();
        // mapTri.put(map2., mapTri)
    }

    public void afficheDetailPoke() {

    }

    public void afficheAllArene() {

    }

}