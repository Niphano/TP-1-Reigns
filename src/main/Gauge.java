package main;

/**
 * Représente une jauge avec un nom, une valeur, un type et une valeur maximale.
 */
public class Gauge {
    private TypeJauge type;
    private String nom;
    private int value;
    private int maxValue;


    public Gauge(String nom, int value, int maxValue, TypeJauge type) {
        this.nom = nom;
        this.value = value;
        this.maxValue = maxValue;
        this.type = type;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value >= 0 && value <= this.maxValue) {
            this.value = value;
        } else if (value < 0) {
            this.value = 0;
        } else {
            this.value = this.maxValue;
        }
    }

    public void incrementerValeur(int delta) {
        this.value += delta;
        if (this.value < 0) {
            this.value = 0;
        } else if (this.value > this.maxValue) {
            this.value = this.maxValue;
        }
    }

    public TypeJauge getType() {
        return type;
    }


    public void setType(TypeJauge type) {
        this.type = type;
    }

    public void showGauge() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.value; i++) {
            sb.append("|");
        }
        for (int i = 0; i < GAUGE_LENGTH - this.value; i++) {
            sb.append(" ");
        }
        sb.append("] ");
        sb.append(this.nom);
        System.out.println(sb.toString());
    }

    public boolean estDepassee() {
        return this.value <= 0 || this.value >= this.maxValue;
    }

    public static int valInitJauge(int borneInf, int borneSup) {
        return borneInf + (int) (Math.random() * (borneSup - borneInf));
    }

    public int getMaxValue() {
        return this.maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
}
