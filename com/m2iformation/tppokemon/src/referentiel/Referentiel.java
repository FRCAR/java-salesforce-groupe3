package referentiel;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Referentiel {
    private static Roucoul roucoul1 = new Roucoul(Integer.valueOf((int) (Math.random() * 150)), "monRoucoul", "Roucoul",
            EnumType.VOL, 90);
    private static Carapuce carapuce1 = new Carapuce(Integer.valueOf((int) (Math.random() * 150)), "monCarapuce",
            "Carapuce",
            EnumType.EAU, 100);
    private static Salameche salameche1 = new Salameche(Integer.valueOf((int) (Math.random() * 150)), "monSalameche",
            "Salameche",
            EnumType.FEU, 100);
    private static Racaillou racaillou1 = new Racaillou(Integer.valueOf((int) (Math.random() * 150)), "monRacaillou",
            "Racaillou",
            EnumType.SOL, 110);
    public static Map<Double, String> map = new HashMap<>();
    static Map<Integer, Object> mambo = new TreeMap<Integer, Object>();

    public void RecupAllPokeParOrdre(TreeMap<Integer, Object> mambo) {
        mambo.put(salameche1.getPointsXp(), salameche1);
        mambo.put(carapuce1.getPointsXp(), carapuce1);
        mambo.put(roucoul1.getPointsXp(), roucoul1);
        mambo.put(racaillou1.getPointsXp(), carapuce1);
        for (Entry<Integer, Object> entrees : mambo.entrySet()) {
            System.out.println("Mon index est " + entrees.getKey() + " je suis " + entrees.getValue());
        }
    }

    public void RecupAllPoke(Map<Double, String> map) {
        map.put(salameche1.getPokeId(),
                salameche1.getSurnom() + ". Mon espece est " + salameche1.getEspece() + ". Mon type est " +
                        salameche1.getType() + ". Mon XP est de " + salameche1.getPointsXp()
                        + ". Mes points de vies max sont de " + salameche1.getPointsDeVieMax()
                        + ". Mes points de vie actuels sont de :" + salameche1.getPointsDeVie());
        map.put(carapuce1.getPokeId(), carapuce1.getSurnom() + ". Mon espece est " + carapuce1.getEspece()
                + ". Mon type est " +
                carapuce1.getType() + ". Mon XP est de " + carapuce1.getPointsXp()
                + ". Mes points de vies max sont de " + carapuce1.getPointsDeVieMax()
                + ". Mes points de vie actuels sont de :" + carapuce1.getPointsDeVie());
        map.put(racaillou1.getPokeId(), racaillou1.getSurnom() + ". Mon espece est " + racaillou1.getEspece()
                + ". Mon type est" +
                racaillou1.getType() + ". Mon XP est de " + racaillou1.getPointsXp()
                + ". Mes points de vies max sont de " + racaillou1.getPointsDeVieMax()
                + ". Mes points de vie actuels sont de :" + racaillou1.getPointsDeVie());
        map.put(roucoul1.getPokeId(), roucoul1.getSurnom() + ". Mon espece est " + roucoul1.getEspece()
                + ". Mon type est" +
                roucoul1.getType() + ". Mon XP est de " + roucoul1.getPointsXp()
                + ". Mes points de vies max sont de " + roucoul1.getPointsDeVieMax()
                + ". Mes points de vie actuels sont de :" + roucoul1.getPointsDeVie());
        for (java.util.Map.Entry<Double, String> entrees : map.entrySet()) {
            System.out.println("Mon index est " + entrees.getKey() + " je suis " + entrees.getValue());
        }
    }
    // public void RecupPokeParId(int id) {
    // map.get(id);
    // }

    public void updatePoke(Espece espece) {

    }

    public static void main(String[] args) {
        System.out.println("Mon id est " + salameche1.getPokeId() + " je m'apelle " + salameche1.getSurnom()
                + ", mon espece est " + salameche1.getEspece() +
                " je suis de type " + salameche1.getType() + " mes points de vie max sont de : "
                + salameche1.getPointsDeVieMax());

        Referentiel monref = new Referentiel();
        monref.RecupAllPoke(map);
        monref.RecupAllPokeParOrdre((TreeMap<Integer, Object>) mambo);
    }

    public static Map<Double, String> getMap() {
        return map;
    }
}
