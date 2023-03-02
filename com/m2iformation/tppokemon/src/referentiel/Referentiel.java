package referentiel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Referentiel {
    // private static Random rand = new Random();
    // private static int max = 4;
    // private static int min = 1;
    private static Roucoul roucoul1 = new Roucoul(1, "Chouchou", "Roucoul",
            EnumType.VOL, 90);
    private static Carapuce carapuce1 = new Carapuce(2, "Cara",
            "Carapuce",
            EnumType.EAU, 100);
    private static Salameche salameche1 = new Salameche(3, "ToutFeuToutFlamme",
            "Salameche",
            EnumType.FEU, 100);
    private static Racaillou racaillou1 = new Racaillou(4, "Pierre",
            "Racaillou",
            EnumType.SOL, 110);
    public static Map<Integer, Espece> getPokeOrdonneInv() {
        return pokeOrdonneInv;
    }

    public static void setPokeOrdonneInv(Map<Integer, Espece> pokeOrdonneInv) {
        Referentiel.pokeOrdonneInv = pokeOrdonneInv;
    }

    public static Map<Integer, Espece> map = new HashMap<>();
    public static Map<Integer, Espece> pokeOrdonne = new TreeMap<>();
    public static Map<Integer, Espece> pokeOrdonneInv = new TreeMap<>(Collections.reverseOrder());

   

    public static Map<Integer, Espece> getPokeOrdonne() {
        return pokeOrdonne;
    }



    public static Map<Integer, Espece> getMap() {
        return map;
    }



    public void RecupAllPoke(Map<Integer, Espece> map) {
        map.put((int) racaillou1.getPokeId(), carapuce1);
        map.put((int) salameche1.getPokeId(), salameche1);
        map.put((int) carapuce1.getPokeId(), racaillou1);
        map.put((int) roucoul1.getPokeId(), roucoul1);
        for (Map.Entry<Integer, Espece> entrees : map.entrySet()) {
            System.out.println("Mon id est " + entrees.getKey() + " je suis " + entrees.getValue().getSurnom()+ ", un " + entrees.getValue().getEspece());
        }
    }
    
    
   
    public void RecupAllPokeParOrdre(Map<Integer, Espece> pokeOrdonne) {
        salameche1.setPointsXp(20);
        carapuce1.setPointsXp(15);
        roucoul1.setPointsXp(17);
        racaillou1.setPointsXp(10);
        pokeOrdonne.put(racaillou1.getPointsXp(), racaillou1);
        pokeOrdonne.put(salameche1.getPointsXp(), salameche1);
        pokeOrdonne.put(carapuce1.getPointsXp(), carapuce1);
        pokeOrdonne.put(roucoul1.getPointsXp(), roucoul1);
        for (Map.Entry<Integer, Espece> xp : pokeOrdonne.entrySet()) {
            System.out.println("Mon XP est " + xp.getKey() + " je suis " + xp.getValue().getSurnom()+ ", un " + xp.getValue().getEspece());
        }
    }
    
    public void RecupPokeParId(Integer id) {
        for (Entry<Integer, Espece> entrees : map.entrySet()) {
            if (id == entrees.getKey()) {
                // return this.map.get(id);
                System.out.println("Mon index est " + entrees.getKey() + " je suis " + entrees.getValue().getSurnom());
            }
        }
    }

    public void afficheDetailPoke(Integer id) {
        for (java.util.Map.Entry<Integer, Espece> entrees : map.entrySet()) {
            if (id == entrees.getKey()) {
                // return this.map.get(id);
                System.out.println("Mon id est " + entrees.getKey() + " je suis " + entrees.getValue().getSurnom()
                        + ", mon espece est " + entrees.getValue().getEspece()
                        + " mon Type est : " + entrees.getValue().getType() + " , mes points de vie max sont de : "
                        + entrees.getValue().getPointsDeVieMax() + " et mon XP est de : "
                        + entrees.getValue().getPointsXp());
            }
        }
    }
    // public void updatePoke(Espece espece) {
    // if(this.map.containsKey(espece.getId())){
    // this.map.put(espece.getPokeId(),espece);
    // }

    // }

    public void updatePoke(Espece espece) {

    }

    public static void main(String[] args) {
    
        Referentiel monref = new Referentiel();
        monref.RecupAllPoke(map);
        monref.RecupAllPokeParOrdre(pokeOrdonne);
        monref.RecupPokeParId(3);
        monref.afficheDetailPoke(3);
 
   
    }


}
