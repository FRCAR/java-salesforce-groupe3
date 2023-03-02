package entrainement;

import referentiel.Carapuce;
import referentiel.Racaillou;
import referentiel.Roucoul;
import referentiel.Salameche; 

public class SimulationEntrainement {
    Salameche monSalameche;
    Roucoul monRoucoul;
    Carapuce monCarapuce;
    Racaillou monRacaillou;
    Arene monArene;
    Combat monCombat;
   
    public static void main(String[] args) {

        afficheAllArene();
    }

    public void afficheAllPokeParOdre() {

    }

    public void afficheDetailPoke() {

    }

    public static void afficheAllArene() {

        System.out.println("Liste de toutes les arènes :");
        for (EnumArene arena : EnumArene.values()) {
            System.out.println(" - " + arena);
    }

    }
}