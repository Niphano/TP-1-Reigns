package main;

import java.util.ArrayList;
import java.util.Map;

public class BDD {
    private static ArrayList<Question> liste;

    /*
     * Cette fonction initialise la banque de questions. Elle crée les questions et les ajoute à la banque.
     */

    public void initListe(){
        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniers",
                new Effet("Oui", "G", new AlterationJauge(
                        Map.of(
                                TypeJauge.ARMEE,-5,
                                TypeJauge.PEUPLE,+5
                        )
                ) ),
                new Effet("Non","D", new AlterationJauge(
                        Map.of(
                                TypeJauge.PEUPLE,+5
                        )
                ))
        );
        liste.add(question1);

        Question question2 = new Question(
                "Paysan",
                "Il n'y a plus rien à manger",
                new Effet("Importer de la nourriture", "G", new AlterationJauge(
                        Map.of(
                                TypeJauge.FINANCE,-5,
                                TypeJauge.PEUPLE, +5
                        )
                ) ),
                new Effet("Ne rien faire","D", new AlterationJauge(
                        Map.of(
                                TypeJauge.PEUPLE, -5
                        )
                ))
        );
        liste.add(question2);

        Question question3 = new Question(
                "Prêtre",
                "Les dieux sont en colère",
                new Effet("Faire un sacrifice", "G", new AlterationJauge(
                        Map.of(
                                TypeJauge.CLERGE, +5,
                                TypeJauge.PEUPLE, -3
                        )
                ) ),
                new Effet("Ne rien faire","D", new AlterationJauge(
                        Map.of(
                                TypeJauge.CLERGE, -5
                        )
                ))
        );
        liste.add(question3);

        Question question4 = new Question(
                "Main du roi",
                "Le roi Baratheon rassemble son armée",
                new Effet("Le soutenir", "G", new AlterationJauge(
                        Map.of(
                                TypeJauge.ARMEE, +3,
                                TypeJauge.FINANCE, -3,
                                TypeJauge.CLERGE, -3
                        )
                ) ),
                new Effet("Rester neutre","D", new AlterationJauge(
                        Map.of(
                                TypeJauge.PEUPLE, +3
                        )
                ))
        );
        liste.add(question4);

        Question question5 = new Question(
                "Paysan",
                "Abondance de récoltes cette année",
                new Effet("Taxer énormément", "G", new AlterationJauge(
                        Map.of(
                                TypeJauge.FINANCE, +10,
                                TypeJauge.PEUPLE, -5
                        )
                ) ),
                new Effet("Taxer un tout petit peu","D", new AlterationJauge(
                        Map.of(
                                TypeJauge.FINANCE, +1,
                                TypeJauge.PEUPLE, -3
                        )
                ))
        );
        liste.add(question5);

    }

    public BDD() {
        liste = new ArrayList<>();
        initListe();
    }
    /*
     * Cette fonction permet de tirer une question aléatoire dans la banque de questions.
     * @return Une question aléatoire
     */
    public Question getQuestionAleatoire(){
        int numQuestion = (int) (Math.random()*liste.size());
        return liste.get(numQuestion);
    }
}