package com.david.irregularverbstrainer;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class VerbTrainerTest {

    private VerbTrainer verbTrainer;

    @Before
    public void setUp() {
        verbTrainer = new VerbTrainer(AppConfig.DICTIONARY_PATH_IN_JAR);
    }

    @Test
    public void testGetRandomIrregularVerb() {
        IrregularVerb randomVerb = verbTrainer.getRandomIrregularVerb();

        assertNotNull(randomVerb);
        assertNotNull(randomVerb.getInfinitive());
        assertNotNull(randomVerb.getPast());
        assertNotNull(randomVerb.getPastParticiple());
    }

    @Test
    public void testTrainingWithCorrectAnswer() {
        IrregularVerb randomVerb = verbTrainer.getRandomIrregularVerb();

        // Simulate user input with correct answers
        String pastInput = randomVerb.getPast();
        String pastParticipleInput = randomVerb.getPastParticiple();

        IrregularVerb inputVerb = new IrregularVerb(randomVerb.getInfinitive(), pastInput, pastParticipleInput);

        assertTrue(inputVerb.equals(randomVerb));
    }

    @Test
    public void testTrainingWithIncorrectAnswer() {
        IrregularVerb randomVerb = verbTrainer.getRandomIrregularVerb();

        // Simulate user input with incorrect answers
        String pastInput = "IncorrectPast";
        String pastParticipleInput = "IncorrectParticiple";

        IrregularVerb inputVerb = new IrregularVerb(randomVerb.getInfinitive(), pastInput, pastParticipleInput);

        assertFalse(inputVerb.equals(randomVerb));
    }

    @Test
    public void testLoadingIrregularVerbsFromJar() {
        // Assuming dictionary.csv is correctly formatted in the resources folder
        List<IrregularVerb> irregularVerbs = verbTrainer.getAllIrregularVerbsFromJar(AppConfig.DICTIONARY_PATH_IN_JAR);

        assertNotNull(irregularVerbs);
        assertFalse(irregularVerbs.isEmpty());
    }
}
