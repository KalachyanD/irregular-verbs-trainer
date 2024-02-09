package com.david.irregularverbstrainer;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VerbsFileReaderFromCsv {
    private final int verbFormsNumber = 3;

    List<IrregularVerb> getAllIrregularVerbs(String filePath) {

        List<IrregularVerb> irregularVerbs = new ArrayList<>();
        ClassLoader classLoader = Main.class.getClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(filePath);
             Scanner scanner = new Scanner(inputStream)) {

            String line;
            String[] array;

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                array = line.split(",");

                if (array.length == verbFormsNumber) {
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
}

