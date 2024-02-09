package com.david.irregularverbstrainer;

import java.util.List;
import java.util.Scanner;

public class VerbTrainer {
    private final List<IrregularVerb> irregularVerbs;

    VerbTrainer(String filePath) {
        VerbsFileReaderFromCsv verbsFileReader = new VerbsFileReaderFromCsv();
        this.irregularVerbs = verbsFileReader.getAllIrregularVerbs(filePath);
    }

    void train(int iterationsCount) throws Exception {

        if(iterationsCount < 1){
            throw new Exception("ITERATIONS_COUNT < 1, please update app configuration.");
        }

        IrregularVerbsRandomizer randomizer = new IrregularVerbsRandomizer();
        IrregularVerb randomIrregularVerb;

        //interaction with user logic
        Scanner scanner = new Scanner(System.in);
        String pastInput;
        String pastParticipleInput;

        //welcoming message
        System.out.println("Welcome to irregular verbs trainer! You will train " + iterationsCount + " verbs.");

        for(int i = 0 ; i < iterationsCount ; ++i) {
            //training iteration
            System.out.println((i + 1) + ".");
            randomIrregularVerb = randomizer.getOneRandomIrregularVerb(irregularVerbs);
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
        }

        //finishing message
        System.out.println("Training has been finished! See you next time!");
    }

}

