package Referentiel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Referentiel {
    Map<int id, Espece espece> map = new HashMap<>();
    public void RecupAllPoke(){
        Iterator iterator=map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry map = (Map.Entry) iterator.next();
            map.getKey();
            map.getValue();
        }
    }
    public void RecupPokeParId(int id){
        map.get(id);
    }
    public void updatePoke(Espece espece){

    }
}
