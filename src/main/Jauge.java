package main;

/**
 * Représente une jauge avec un nom, une valeur et un type.
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Jauge {
    /**
     * Le type de la jauge
     */
    protected TypeJauge type;
    /**
     * Le nom de la jauge
     */
    protected String nom;
    /**
     * La valeur de la jauge
     */
    protected int valeur;


    /**
     * Crée une nouvelle jauge avec le nom et la valeur spécifiés.
     *
     * @param nom Le nom de la jauge
     * @param valeur La valeur de la jauge
     */
    public Jauge(String nom, int valeur){
        this.nom = nom;
        this.valeur = valeur;
    }

    /**
     * Retourne le nom de la jauge.
     *
     * @return le nom de la jauge
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne la valeur de la jauge.
     *
     * @return la valeur de la jauge
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * Modifie la valeur de la jauge.
     *
     * @param valeur La nouvelle valeur de la jauge
     */
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}
