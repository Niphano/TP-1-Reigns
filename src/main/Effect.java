package main;

public class Effect {
    private String nom;
    private String alias;
    private String desription;
    private AbstractEffect action;

    public Effect(String nom, String alias, AbstractEffect strategie) {
        this.nom = nom;
        this.alias = alias;
        this.action = strategie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDesription() {
        return desription;
    }

    public void appliquer(){
        this.action.appliqueEffect();
    }

    public void afficher(){
        System.out.println(this.action.traffickerEffect());
    }
}