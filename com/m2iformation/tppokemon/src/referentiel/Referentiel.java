package referentiel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Referentiel {


    Map<Integer, Espece> map = new HashMap<>();

    public void RecupAllPoke() {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry map = (Map.Entry) iterator.next();
            map.getKey();
            map.getValue();
        }
    }

    public void RecupPokeParId(int id) {
        map.get(id);
    }

    public void updatePoke(Espece espece) {

    }

    public static void main(String[]args){
        Roucoul roucoul1 = new Roucoul(Integer.valueOf((int) (Math.random() * 150)), "monRoucoul", "Salameche",
                EnumType.VOL, 90);
        Carapuce carapuce1 = new Carapuce(Integer.valueOf((int) (Math.random() * 150)), "monCarapuce", "Salameche",
                EnumType.EAU, 100);
        Racaillou racaillou1 = new Racaillou(Integer.valueOf((int) (Math.random() * 150)), "monRacaillou", "Salameche",
                EnumType.SOL, 110);
        Salameche salameche1 = new Salameche(Integer.valueOf((int) (Math.random() * 150)), "monSalameche", "Salameche",
                EnumType.FEU, 100);
        System.out.println("Mon id est " + salameche1.getPokeId() + " je m'apelle " + salameche1.getSurnom()
                + ", mon espece est " + salameche1.getEspece() +
                " je suis de type " + salameche1.getType() + " mes points de vie max sont de : "
                + salameche1.getPointsDeVieMax());  
    }
}
