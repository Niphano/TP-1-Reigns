package main;

import java.util.Map;

public class AlterationJauge extends AbstractEffect {
    private Map<TypeJauge,Integer> jaugesCibles;

    static Character PERSO_CIBLE;

    public AlterationJauge(Map<TypeJauge, Integer> jaugesCibles) {
        this.jaugesCibles = jaugesCibles;
    }

    @Override
    void strategiesEffect() {
        for(Map.Entry<TypeJauge,Integer> paire : jaugesCibles.entrySet()){
            TypeJauge type = paire.getKey();
            int valeur = paire.getValue();
            PERSO_CIBLE.getGaugeByType(type).incrementerValeur(valeur);
        }
        //super.PERSO_CIBLE.;
    }

    @Override
    String traffickerEffect() {
        String res = "";
        for(Map.Entry<TypeJauge,Integer> paire : jaugesCibles.entrySet()){
            res += GaugesBank.getNomTypeJauge().get(paire.getKey()) + " : " + paire.getValue().toString() + " ; ";
        }
        return res;
    }
}