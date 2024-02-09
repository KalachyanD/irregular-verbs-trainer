package com.david.irregularverbstrainer;

import java.util.List;
import java.util.Random;

public class IrregularVerbsRandomizer {
    private final Random randomizer;

    IrregularVerbsRandomizer(){
        randomizer = new Random();
    }

    IrregularVerb getOneRandomIrregularVerb(List<IrregularVerb> irregularVerbs) {

        if(irregularVerbs.size() > 1){
            return irregularVerbs.get(randomizer.nextInt(irregularVerbs.size()));
        }else{
            return irregularVerbs.get(0);
        }
    }
}
