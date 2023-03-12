package main;

import java.util.Map;

/**
 * La classe Reigns représente le programme principal du jeu Reigns
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Reigns {

    private static int nbTours;

    /**
     * le personnage joué
     */
    private static Character personnage;

    /**
     * la banque de questions
     */
    private static BDD questions;

    /**
     * La méthode main lance le jeu Reigns. Il initialise les questions, le personnage,
     * affiche les jauges du personnage et lance une boucle de jeu qui se termine lorsque le personnage perd.
     * Il affiche également le nombre de tours de jeu que le personnage a joué.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args){

        // début du jeu
        initialiser_partie();
        nbTours = 0;

        // tirage des questions, boucle principale (tours du jeu)
        boucle_jeu();

        // fin du jeu
        fin_partie();

    }

    private static void initialiser_partie(){
        System.out.println("Bienvenue sur Reigns");

        questions = new BDD();

        System.out.println("Création du personnage...");

        Reigns.personnage = new Character();

        AlterationJauge.PERSO_CIBLE = Reigns.personnage;

        System.out.println(personnage.getGenre().longRegne()
                +" "+personnage.getName());

        personnage.showGauges();
    }

    private static void boucle_jeu(){

        while(!personnage.finDuJeu()){

            Question question = questions.getQuestionAleatoire();
            reponseQuestion(question);
            personnage.showGauges();
            nbTours = nbTours + 1;
        }
    }

    private static void fin_partie(){
        System.out.println(
                personnage.getName()
                        + " a perdu ! Son règne a duré "
                        +nbTours
                        + " tours");
    }

    private static void reponseQuestion(Question question){
        question.afficheQuestion();
        String reponse = "";

        reponse = (String) UI.showQuestion("Entrez la réponse (G ou D)",
                Map.of(
                        "G","G",
                        "D","D"
                ),
                null);

        // applique les malus
        if(reponse.equals("G")){
            question.appliqueEffetsGauche(personnage);
        }else{
            question.appliqueEffetsDroite(personnage);
        }
    }

}