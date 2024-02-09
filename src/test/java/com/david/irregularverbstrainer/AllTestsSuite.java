package com.david.irregularverbstrainer;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        VerbsFileReaderFromCsvTest.class,
        IrregularVerbsRandomizerTest.class
})
public class AllTestsSuite {
}
