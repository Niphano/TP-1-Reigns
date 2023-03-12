package main;

import java.util.Map;
import java.util.Scanner;

public class InterfaceTexte {

    private static final Scanner fluxIn = new Scanner(System.in);

    public static String saisieTexteLibre(String question){
        System.out.println(question);
        System.out.flush();
        return fluxIn.nextLine();
    }

    public static Object chercherDansReponses(String test,Map<String,Object> reponses){
        for(Map.Entry<String,Object> paire : reponses.entrySet()){
            if(test.equals(paire.getKey())){
                return paire.getValue();
            }
        }
        return null;
    }

    public static Object reponseQCM(String question, Map<String,Object> reponses,Object force){
        boolean reponseValide = false;
        Object res = null;
        while(res == null){
            System.out.println(question);
            System.out.flush();
            res = chercherDansReponses(fluxIn.nextLine(),reponses);
            if(force != null && res == null) {
                return force;
            }
        }
        return res;
    }
}