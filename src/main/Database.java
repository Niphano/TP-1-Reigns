package main;

import java.util.ArrayList;
import java.util.Map;

public class Database {
    private static ArrayList<Question> liste;

    /*
     * Cette fonction initialise la banque de questions. Elle crée les questions et les ajoute à la banque.
     */

    public void initListe(){
        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniers",
                new Effect("Oui", "G", new GaugeChanges(
                        Map.of(
                                TypeJauge.ARMEE,-5,
                                TypeJauge.PEUPLE,+5
                        )
                ) ),
                new Effect("Non","D", new GaugeChanges(
                        Map.of(
                                TypeJauge.PEUPLE,+5
                        )
                ))
        );
        liste.add(question1);

        Question question2 = new Question(
                "Paysan",
                "Il n'y a plus rien à manger",
                new Effect("Importer de la nourriture", "G", new GaugeChanges(
                        Map.of(
                                TypeJauge.FINANCE,-5,
                                TypeJauge.PEUPLE, +5
                        )
                ) ),
                new Effect("Ne rien faire","D", new GaugeChanges(
                        Map.of(
                                TypeJauge.PEUPLE, -5
                        )
                ))
        );
        liste.add(question2);

        Question question3 = new Question(
                "Prêtre",
                "Les dieux sont en colère",
                new Effect("Faire un sacrifice", "G", new GaugeChanges(
                        Map.of(
                                TypeJauge.CLERGE, +5,
                                TypeJauge.PEUPLE, -3
                        )
                ) ),
                new Effect("Ne rien faire","D", new GaugeChanges(
                        Map.of(
                                TypeJauge.CLERGE, -5
                        )
                ))
        );
        liste.add(question3);

        Question question4 = new Question(
                "Main du roi",
                "Le roi Baratheon rassemble son armée",
                new Effect("Le soutenir", "G", new GaugeChanges(
                        Map.of(
                                TypeJauge.ARMEE, +3,
                                TypeJauge.FINANCE, -3,
                                TypeJauge.CLERGE, -3
                        )
                ) ),
                new Effect("Rester neutre","D", new GaugeChanges(
                        Map.of(
                                TypeJauge.PEUPLE, +3
                        )
                ))
        );
        liste.add(question4);

        Question question5 = new Question(
                "Paysan",
                "Abondance de récoltes cette année",
                new Effect("Taxer énormément", "G", new GaugeChanges(
                        Map.of(
                                TypeJauge.FINANCE, +10,
                                TypeJauge.PEUPLE, -5
                        )
                ) ),
                new Effect("Taxer un tout petit peu","D", new GaugeChanges(
                        Map.of(
                                TypeJauge.FINANCE, +1,
                                TypeJauge.PEUPLE, -3
                        )
                ))
        );
        liste.add(question5);

    }

    public Database() {
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