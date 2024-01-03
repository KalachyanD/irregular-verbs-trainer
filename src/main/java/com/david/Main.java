package com.david;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String dictionaryPath = "/Users/kalachyand/IdeaProjects/irregular-verbs-trainer/src/main/resources/dictionary.csv";

        IrregularVerb randomIrregularVerb = getRandomIrregularVerb(getAllIrregularVerbsFromFile(dictionaryPath));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Infinitive: " + randomIrregularVerb.getInfinitive());
        System.out.print("Past: ");
        String pastInput = scanner.nextLine();
        System.out.print("Past Participle: ");
        String pastParticipleInput = scanner.nextLine();

        IrregularVerb inputVerb = new IrregularVerb(randomIrregularVerb.getInfinitive(), pastInput, pastParticipleInput);

        if(randomIrregularVerb.equals(inputVerb)){
            System.out.print("Correct");
        }else{
            System.out.print("Incorrect");
        }

    }

    private static List<IrregularVerb> getAllIrregularVerbsFromFile(String filePath){
        List<IrregularVerb> irregularVerbs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] array = new String[3];

            while ((line = reader.readLine()) != null) {

                array = line.split(",");
                irregularVerbs.add(new IrregularVerb(array[0],array[1],array[2]));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return irregularVerbs;
    }

    private static IrregularVerb getRandomIrregularVerb(List<IrregularVerb> irregularVerbList){
        if(irregularVerbList != null && irregularVerbList.size() != 0){
            if(irregularVerbList.size() > 1){
                Random random = new Random();
                return irregularVerbList.get(random.nextInt(irregularVerbList.size()));
            }else{
                return irregularVerbList.get(0);
            }
        }else{
            return null;
        }
    }
}