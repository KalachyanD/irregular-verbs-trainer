package com.david;

import java.io.InputStream;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args){

        String dictionaryPathJar = "dictionary.csv";

        try{
            List<IrregularVerb> allVerbs = getAllIrregularVerbsFromJar(dictionaryPathJar);

            IrregularVerb randomIrregularVerb = getRandomIrregularVerb(allVerbs);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Infinitive: " + randomIrregularVerb.getInfinitive());
            System.out.print("Past: ");
            String pastInput = scanner.nextLine();
            System.out.print("Past Participle: ");
            String pastParticipleInput = scanner.nextLine();

            IrregularVerb inputVerb = new IrregularVerb(randomIrregularVerb.getInfinitive(), pastInput, pastParticipleInput);

            if(randomIrregularVerb.equals(inputVerb)){
                System.out.print("Correct\n");
            }else{
                System.out.print("Incorrect\n");
            }

        }catch (Exception e){
            System.out.println("Something went wrong.");
        }

    }

    private static List<IrregularVerb> getAllIrregularVerbsFromJar(String filePath){
        List<IrregularVerb> irregularVerbs = new ArrayList<>();

        ClassLoader classLoader = Main.class.getClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(filePath);
             Scanner scanner = new Scanner(inputStream)) {

            String line;
            String[] array;

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                array = line.split(",");
                irregularVerbs.add(new IrregularVerb(array[0], array[1], array[2]));
            }

        } catch (Exception e) {
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