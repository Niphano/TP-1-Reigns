package main;

import java.util.Map;
import java.util.Scanner;

public class UI {

    private static final Scanner scanner = new Scanner(System.in);

    public static String askForString(String question){
        System.out.println(question);
        return scanner.nextLine();
    }

    public static int askForInt(String question){
        int value = 0;
        boolean validInput = false;
        while(!validInput){
            System.out.println(question);
            try{
                value = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch(NumberFormatException e){
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        return value;
    }

    public static double askForDouble(String question){
        double value = 0;
        boolean validInput = false;
        while(!validInput){
            System.out.println(question);
            try{
                value = Double.parseDouble(scanner.nextLine());
                validInput = true;
            } catch(NumberFormatException e){
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return value;
    }

    public static boolean askForBoolean(String question){
        System.out.println(question + " (y/n)");
        String response = scanner.nextLine();
        while(!response.equals("y") && !response.equals("n")){
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
            response = scanner.nextLine();
        }
        return response.equals("y");
    }

    public static <T> T showQuestion(String question, Map<String,T> responses, T defaultValue){
        while(true){
            System.out.println(question);
            for(String response : responses.keySet()){
                System.out.println(response);
            }
            String userInput = scanner.nextLine();
            if(responses.containsKey(userInput)){
                return responses.get(userInput);
            } else if(userInput.isEmpty() && defaultValue != null){
                return defaultValue;
            } else{
                System.out.println("Invalid input. Please enter a valid option.");
            }
        }
    }

}
