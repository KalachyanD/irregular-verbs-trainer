package com.david.irregularverbstrainer;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class VerbsFileReaderFromCsvTest {

    private VerbsFileReaderFromCsv verbsFileReaderFromCsv;

    @Before
    public void setUp() {
        verbsFileReaderFromCsv = new VerbsFileReaderFromCsv();
    }

    @Test
    public void testGetAllIrregularVerbs() {
        List<IrregularVerb> allIrregularVerbs = verbsFileReaderFromCsv.getAllIrregularVerbs(AppConfig.DICTIONARY_PATH_IN_JAR);

        assertNotNull(allIrregularVerbs);
        assertTrue(allIrregularVerbs.size() > 0);
    }
}
