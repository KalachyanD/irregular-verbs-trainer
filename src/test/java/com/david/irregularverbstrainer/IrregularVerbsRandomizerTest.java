package com.david.irregularverbstrainer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IrregularVerbsRandomizerTest {

    private IrregularVerbsRandomizer randomizer;
    private VerbsFileReaderFromCsv reader;

    @Before
    public void setUp() {
        randomizer = new IrregularVerbsRandomizer();
        reader = new VerbsFileReaderFromCsv();
    }

    @Test
    public void testGetRandomIrregularVerb() {
        IrregularVerb randomVerb1 = randomizer.getOneRandomIrregularVerb(reader.getAllIrregularVerbs(AppConfig.DICTIONARY_PATH_IN_JAR));
        IrregularVerb randomVerb2 = randomizer.getOneRandomIrregularVerb(reader.getAllIrregularVerbs(AppConfig.DICTIONARY_PATH_IN_JAR));

        assertNotNull(randomVerb1);
        assertNotNull(randomVerb2);
        assertNotEquals(randomVerb1.getInfinitive(),randomVerb2.getInfinitive());
    }
}
