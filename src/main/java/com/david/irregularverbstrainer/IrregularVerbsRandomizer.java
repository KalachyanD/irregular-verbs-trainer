package com.david.irregularverbstrainer;

import java.util.List;
import java.util.Random;

public class IrregularVerbsRandomizer {
    private final Random randomizer;

    IrregularVerbsRandomizer(){
        randomizer = new Random();
    }

    IrregularVerb getOneRandomIrregularVerb(List<IrregularVerb> irregularVerbs) {
        return irregularVerbs.get(randomizer.nextInt(irregularVerbs.size()));
    }
}
