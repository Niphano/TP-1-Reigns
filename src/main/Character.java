package main;

import java.util.Map;

/**
 * Représente un personnage ayant un nom, un genre, et des jauges de Clergé, Peuple, Armée et Finances.
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Personnage {
    /**
     * Le nom du personnage
     */
    protected String nom;
    /**
     * Le genre du personnage
     */
    protected Genre genre;
    /**
     * La jauge de Clergé
     */
    protected ListeJauges les_jauges;

    /**
     * Crée un nouveau personnage avec le nom et le genre spécifiés,
     * puis initialise les jauges de Clergé, Peuple, Armée et Finances.
     *
     */
    public Personnage() {

        this.nom = UI.traffickerQuestion("Entrez le nom du personnage: ");
        this.genre = (Genre) UI.showQuestion("Faut-il vous appeler Roi ou Reine ? (1 pour Roi, 2 pour Reine)",
                Map.of(
                        "1",Genre.ROI,
                        "2",Genre.REINE
                ),
                Genre.REINE /*  Force cette réponse si pas de réponse valide */ );
        System.out.println(this.genre);
        this.les_jauges = new ListeJauges();
    }



    /**
     * Affiche les jauges du personnage.
     */
    public void AfficheJauges() {
        les_jauges.afficherTout();

    }

    /**
     * Vérifie si le jeu est fini en vérifiant si une des jauges est à 0 ou LONGUEUR_JAUGE.
     *
     * @return true si le jeu est fini, false sinon
     */
    public boolean finDuJeu(){
        return les_jauges.uneJaugeEstDepassee();
    }

    /**
     * Affiche une jauge avec un format graphique, en utilisant des "#" pour représenter la valeur de la jauge
     * et des "_" pour représenter la valeur manquante.
     *
     * @param jauge La jauge à afficher
     */


    /**
     * Retourne le nom du personnage
     * @return le nom du personnage
     */
    public String getNom() {
        return nom;
    }
    /**
     * Modifie le nom du personnage
     * @param nom Le nouveau nom du personnage
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Retourne le genre du personnage
     * @return le genre du personnage
     */
    public Genre getGenre() {
        return genre;
    }
    /**
     * Modifie le genre du personnage
     * @param genre Le nouveau genre du personnage
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Jauge getJaugeSelonType(TypeJauge typeCible){
        return les_jauges.getJaugeSelonType(typeCible);
    }

    /**
     * Retourne la jauge du clergé
     * @return la jauge du clergé
     */


}