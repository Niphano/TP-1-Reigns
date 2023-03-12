package main;

import java.util.Map;
import java.util.Scanner;

/**
 * Représente un personnage ayant un nom, un genre, et des jauges de Clergé, Peuple, Armée et Finances.
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Character {
    Scanner scanner = new Scanner(System.in);
    protected String name;

    protected Genre genre;

    protected GaugesBank gauges;

    public Character() {


        System.out.println("Quel est votre nom ? :");
        this.name = scanner.nextLine();
        this.genre = (Genre) UI.showQuestion("Êtes vous un roi (Tapez '1'), ou une Reine ('2') ? : ",
                Map.of(
                        "1",Genre.ROI,
                        "2",Genre.REINE
                ),
                Genre.ROI /*  Else : Roi */ );
        System.out.println("Vous avez choisi : " + this.genre);
        this.gauges = new GaugesBank();
    }


    public void showGauges() {
        for (TypeJauge typeJauge : TypeJauge.values()) {
            Gauge gauge = gauges.getJaugeSelonType(typeJauge);
            System.out.println(typeJauge.toString() + " : " + gauge.getValue() + " / " + gauge.getMaxValue());
        }
    }

    public boolean finDuJeu(){
        for (TypeJauge typeJauge : TypeJauge.values()) {
            Gauge gauge = gauges.getJaugeSelonType(typeJauge);
            if (gauge.estDepassee()) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Gauge getGaugeByType(TypeJauge typeCible){
        return gauges.getJaugeSelonType(typeCible);
    }
}
