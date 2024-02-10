package com.david.irregularverbstrainer;

public class Main {
    public static void main(String[] args){

        try{
            VerbTrainer verbTrainer = new VerbTrainer(AppConfig.DICTIONARY_PATH_IN_JAR);

            verbTrainer.train(AppConfig.ITERATIONS_COUNT);

        }catch (Exception e){
            System.out.println("Something went wrong.");
        }

    }
}