package main;

import java.util.Map;
import java.util.TreeMap;

public class GaugesBank {
    private Map<TypeJauge, Gauge> liste;

    static private final Map<TypeJauge,String> types = Map.of(
            TypeJauge.ARMEE,"Armee",
            TypeJauge.CLERGE,"Clerge",
            TypeJauge.FINANCE,"Finance",
            TypeJauge.PEUPLE,"Peuple"
    );

    public static Map<TypeJauge,String> getNomTypeJauge(){
        return types;
    }

    public GaugesBank(){
        this.liste = new TreeMap<TypeJauge, Gauge>();
        for(Map.Entry<TypeJauge,String> paire : types.entrySet()){
            TypeJauge type = paire.getKey();
            String nom = paire.getValue();
            this.liste.put(type,new Gauge(nom,Gauge.valInitJauge(15,35),Constants.GAUGE_LENGTH, type));
        }
    }

    public Gauge getJaugeSelonType(TypeJauge typeCible){
        return this.liste.get(typeCible);
    }

    public void afficherTout(){
        for(Map.Entry<TypeJauge, Gauge> paire : this.liste.entrySet()){
            Gauge la_gauge = paire.getValue();
            la_gauge.showGauge();
        }
    }

    public boolean uneJaugeEstDepassee(){
        boolean res = false;
        for(Map.Entry<TypeJauge, Gauge> paire : this.liste.entrySet()){
            Gauge la_gauge = paire.getValue();
            res = res || la_gauge.estDepassee();
        }
        return res;
    }
}
