package main;

import java.util.Map;

/**
 * La classe Question représente une question avec ses effets sur les jauges d'un personnage
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Question {
    /**
     * nom du personnage associé à la question
     */
    protected String nomPersonnage;
    /**
     * la question
     */
    protected String question;
    /**
     * l'effet de la réponse de gauche
     */
    /**
     * les effets sur les jauges pour la réponse de gauche
     */
    protected Effect effectGauche;
    /**
     * les effets sur les jauges pour la réponse de droite
     */
    protected Effect effectDroite;

    /**
     * Construit une nouvelle question avec les informations données
     *
     * @param nomPersonnage Le nom du personnage associé à la question
     * @param question La question à poser
     * @param effectGauche L'effet de la réponse de gauche
     * @param effectDroite L'effet de la réponse de droite
     */
    public Question(String nomPersonnage,
                    String question,
                    Effect effectGauche,
                    Effect effectDroite) {
        this.nomPersonnage = nomPersonnage;
        this.question = question;
        this.effectGauche = effectGauche;
        this.effectDroite = effectDroite;
    }

    /**
     * Affiche la question avec les effets associés aux choix gauche et droit.
     */
    public void afficheQuestion() {
        String result = "["+nomPersonnage+"] "
                + question
                + "[" + effectGauche.getAlias() + " : "+ effectGauche.getNom()
                + "," + effectDroite.getAlias() + " : "+ effectDroite.getNom()
                + "]";
        System.out.println(result);
        System.out.println("Effet "+ effectGauche.getAlias() +" : ");
        effectGauche.afficher();
        System.out.println("Effet " + effectDroite.getAlias() +" : ");
        effectDroite.afficher();
        System.out.flush();
    }

    /**
     * Retourne une chaîne de caractères représentant les effets d'une jauge.
     *
     * @param effets La map des effets de jauge
     * @return la chaîne de caractères représentant les effets de la jauge
     */

    private String afficheEffets(Map<TypeJauge, Integer> effets) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<TypeJauge, Integer> effet : effets.entrySet()) {
            result.append("; jauge ").append(effet.getKey()).append(":");
            if (effet.getValue() > 0) {
                result.append("+");
            }
            result.append(effet.getValue());
        }
        return result.toString();
    }

    /**
     * Applique les effets associés au choix gauche sur un personnage donné.
     *
     * @param personnage le personnage sur lequel les effets doivent être appliqués
     */
    public void appliqueEffetsGauche(Character personnage){
        this.effectGauche.appliquer();
    }

    /**
     * Applique les effets associés au choix droit sur un personnage donné.
     *
     * @param personnage le personnage sur lequel les effets doivent être appliqués
     */
    public void appliqueEffetsDroite(Character personnage){
        this.effectDroite.appliquer();
    }

    /**
     * Applique les effets d'une jauge sur un personnage donné.
     *
     * @param effets les effets de jauge à appliquer
     * @param personnage le personnage sur lequel les effets doivent être appliqués
     */
    private void appliqueEffets(Map<TypeJauge,Integer> effets,
                                Character personnage){
        for(Map.Entry<TypeJauge,Integer> effet : effets.entrySet()){

            personnage.getGaugeByType(effet.getKey()).incrementerValeur(effet.getValue());

        }
    }

    /**
     * Ajoute un effet à la jauge associée au choix gauche.
     *
     * @param jauge la jauge à laquelle l'effet doit être ajouté
     * @param valeur la valeur de l'effet à ajouter
     */
    /*
    public void ajouteEffetGauche(TypeJauge jauge,
                                  int valeur){
        effetJaugeGauche.put(jauge,valeur);
    }*/

    /**
     * Ajoute un effet à la jauge associée au choix droit.
     *
     * @param jauge la jauge à laquelle l'effet doit être ajouté
     * @param valeur la valeur de l'effet à ajouter
     */
    /*
    public void ajouteEffetDroite(TypeJauge jauge,
                                  int valeur){
        effetJaugeDroite.put(jauge,valeur);
    }
    */


    /**
     * Retourne le nom du personnage associé à la question.
     *
     * @return le nom du personnage associé à la question
     */
    public String getNomPersonnage() {
        return nomPersonnage;
    }

    /**
     * Modifie le nom du personnage associé à la question.
     *
     * @param nomPersonnage le nouveau nom du personnage associé à la question
     */
    public void setNomPersonnage(String nomPersonnage) {
        this.nomPersonnage = nomPersonnage;
    }

    /**
     * Retourne la question.
     *
     * @return la question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Modifie la question.
     *
     * @param question la nouvelle question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Retourne l'effet gauche de la question.
     *
     * @return l'effet gauche de la question.
     */
    public Effect getEffetGauche() {
        return effectGauche;
    }

    /**
     * Modifie l'effet gauche de la question.
     *
     * @param effectGauche le nouvel effet gauche de la question
     */
    public void setEffetGauche(Effect effectGauche) {
        this.effectGauche = effectGauche;
    }

    /**
     * Retourne l'effet droit de la question.
     *
     * @return l'effet droit de la question.
     */
    public Effect getEffetDroite() {
        return effectDroite;
    }

    /**
     * Modifie l'effet droit de la question.
     *
     * @param effectDroite le nouvel effet droit de la question
     */
    public void setEffetDroite(Effect effectDroite) {
        this.effectDroite = effectDroite;
    }

}