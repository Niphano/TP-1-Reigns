package main;

import java.util.Map;

public class GaugeChanges extends AbstractEffect {
    private Map<TypeJauge,Integer> jaugesCibles;

    static Character PERSO_CIBLE;

    public GaugeChanges(TypeJauge jaugeCible, int valeur) {
        this.jaugesCibles = Map.of(jaugeCible, valeur);
    }

    public GaugeChanges(Map<TypeJauge, Integer> jaugesCibles) {
        this.jaugesCibles = jaugesCibles;
    }

    public static GaugeChanges of(TypeJauge jaugeCible, int valeur) {
        return new GaugeChanges(jaugeCible, valeur);
    }

    @Override
    void strategiesEffect() {
        for(Map.Entry<TypeJauge,Integer> paire : jaugesCibles.entrySet()){
            TypeJauge type = paire.getKey();
            int valeur = paire.getValue();
            PERSO_CIBLE.getGaugeByType(type).incrementerValeur(valeur);
        }
    }

    @Override
    String traffickerEffect() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<TypeJauge,Integer> paire : jaugesCibles.entrySet()){
            sb.append(GaugesBank.getNomTypeJauge().get(paire.getKey()))
                    .append(" : ")
                    .append(paire.getValue().toString())
                    .append(" ; ");
        }
        return sb.toString();
    }
}
