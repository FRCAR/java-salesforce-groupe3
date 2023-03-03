package referentiel;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Referentiel {
    // private static Random rand = new Random();
    // private static int max = 4;
    // private static int min = 1;
    public Map<Integer, Espece> map = new HashMap<>();

    public Referentiel() {
        reset();
    }

    public void reset() {
        this.map.clear();

        Roucoul roucoul1 = new Roucoul(1, "Chouchou", "Roucoul",
                EnumType.VOL, 10, 90);
        Carapuce carapuce1 = new Carapuce(2, "Cara",
                "Carapuce",
                EnumType.EAU, 25, 100);
        Salameche salameche1 = new Salameche(3, "ToutFeuToutFlamme",
                "Salameche",
                EnumType.FEU, 30, 100);
        Racaillou racaillou1 = new Racaillou(4, "Pierre",
                "Racaillou",
                EnumType.SOL, 15, 110);
        this.getMap().put(roucoul1.getPokeId(), roucoul1);
        this.getMap().put(carapuce1.getPokeId(), carapuce1);
        this.getMap().put(salameche1.getPokeId(), salameche1);
        this.getMap().put(racaillou1.getPokeId(), racaillou1);
    }

    public Map<Integer, Espece> getMap() {
        return map;
    }

    public Collection<Espece> recupAllPoke() {
        return this.map.values();
    }

    public List<Espece> recupAllPokeParOrdre() {
        return this.map.values().stream().sorted((e1, e2) -> {
            return e2.getPointsXp() - e1.getPointsXp();
        }).toList();
    }

    public void recupPokeParId(Integer id) {
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

}
