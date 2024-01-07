package com.david.irregularverbstrainer;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class VerbTrainer {
    private final List<IrregularVerb> irregularVerbs;
    private final Random randomizer;

    VerbTrainer(String filePath) {
        this.irregularVerbs = this.getAllIrregularVerbsFromJar(filePath);
        this.randomizer = new Random();
    }

    List<IrregularVerb> getAllIrregularVerbsFromJar(String filePath) {

        List<IrregularVerb> irregularVerbs = new ArrayList<>();
        ClassLoader classLoader = Main.class.getClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(filePath);
             Scanner scanner = new Scanner(inputStream)) {

            String line;
            String[] array;

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                array = line.split(",");

                if (array.length == 3) {
                    irregularVerbs.add(new IrregularVerb(array[0], array[1], array[2]));
                } else {
                    throw new Exception("Invalid CSV line " + irregularVerbs.size() + 1 + ".");
                }
            }

            if(irregularVerbs.size() == 0){
                throw new Exception("CSV file is empty or broken.");
            }

        } catch (Exception e) {
            System.err.print(e.getMessage());
        }

        return irregularVerbs;
    }

    IrregularVerb getRandomIrregularVerb() {

        if(irregularVerbs.size() > 1){
            return irregularVerbs.get(randomizer.nextInt(irregularVerbs.size()));
        }else{
            return irregularVerbs.get(0);
        }
    }

    void train(int iterationsCount) throws Exception {

        if(iterationsCount < 1){
            throw new Exception("ITERATIONS_COUNT < 1, please update app configuration.");
        }

        IrregularVerb randomIrregularVerb;

        //interaction with user logic
        Scanner scanner = new Scanner(System.in);
        String pastInput;
        String pastParticipleInput;

        for(int i = 0 ; i < iterationsCount ; ++i) {
            //Welcoming message
            if(i == 0){
                System.out.println("Welcome to irregular verbs trainer! You will train " + iterationsCount + " verbs.");
            }
            //Training iteration
            System.out.println((i + 1) + ".");
            randomIrregularVerb = this.getRandomIrregularVerb();
            System.out.println("Infinitive: " + randomIrregularVerb.getInfinitive());
            System.out.print("Past: ");
            pastInput = scanner.nextLine();
            System.out.print("Past Participle: ");
            pastParticipleInput = scanner.nextLine();

            //checking of equality inserted verb forms and reference ones
            IrregularVerb inputVerb = new IrregularVerb(randomIrregularVerb.getInfinitive(), pastInput, pastParticipleInput);

            //result output for user
            if (randomIrregularVerb.equals(inputVerb)) {
                System.out.println("Result: Correct");
                System.out.println("--------------------");
            } else {
                System.out.println("Result: Incorrect");
                System.out.println("Correct forms:");
                System.out.println("Past: " + randomIrregularVerb.getPast());
                System.out.println("Past Participle: " + randomIrregularVerb.getPastParticiple());
                System.out.println("--------------------");
            }

            //finishing message
            if(i == iterationsCount - 1){
                System.out.println("Training has been finished! See you next time!");
            }
        }
    }

}

