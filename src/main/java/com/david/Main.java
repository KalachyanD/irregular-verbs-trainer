package com.david;

public class Main {
    public static void main(String[] args){

        final String dictionaryPathInJar = "dictionary.csv";

        try{
            VerbTrainer verbTrainer = new VerbTrainer(dictionaryPathInJar);

            verbTrainer.startPractise();

        }catch (Exception e){
            System.out.println("Something went wrong.");
        }

    }
}