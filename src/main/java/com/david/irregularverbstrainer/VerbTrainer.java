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

    void train(){

        //getting one random verb
        IrregularVerb randomIrregularVerb = this.getRandomIrregularVerb();

        //interaction with user logic
        Scanner scanner = new Scanner(System.in);
        System.out.println("Infinitive: " + randomIrregularVerb.getInfinitive());
        System.out.print("Past: ");
        String pastInput = scanner.nextLine();
        System.out.print("Past Participle: ");
        String pastParticipleInput = scanner.nextLine();

        //checking of equality inserted verb forms and reference ones
        IrregularVerb inputVerb = new IrregularVerb(randomIrregularVerb.getInfinitive(), pastInput, pastParticipleInput);

        //result output for user
        if(randomIrregularVerb.equals(inputVerb)){
            System.out.print("Correct\n");
        }else{
            System.out.print("Incorrect\n");
        }
    }

}

