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

    private static final int LONGUEUR_JAUGE = 50;

    static public int valInitJauge(int borneInf,int borneSup){
        return borneInf + (int)(Math.random() * (borneSup - borneInf));
    }

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
     * Modifie le nom de la jauge.
     *
     * @param nom Le nouveau nom de la jauge
     */
    public void setNom(String nom) {
        this.nom = nom;
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

    public void incrementeValeur(int delta) { this.valeur += delta; }

    /**
     * Retourne le type de la jauge.
     *
     * @return le type de la jauge
     */
    public TypeJauge getType() {
        return type;
    }

    /**
     * Modifie le type de la jauge.
     *
     * @param type Le nouveau type de la jauge
     */
    public void setType(TypeJauge type) {
        this.type = type;
    }

    public void showGauge() {
        String result = "[";
        for(int i=0;i<this.valeur;i++){
            result += "|";
        }
        for(int i=0;i<LONGUEUR_JAUGE-(this.valeur);i++){
            result += " ";
        }
        result += "] ";
        // affichage du nom
        result += this.nom;
        System.out.println(result);
    }

    public boolean estDepassee(){
        return this.valeur <= 0 || this.valeur >= LONGUEUR_JAUGE;
    }

}