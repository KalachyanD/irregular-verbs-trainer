package com.david;

public class IrregularVerb {
    private String infinitive;
    private String past;
    private String pastParticiple;

    IrregularVerb(String infinitive, String simplePast, String pastParticiple){
        this.infinitive = infinitive;
        this.past = simplePast;
        this.pastParticiple = pastParticiple;
    }

    String getInfinitive(){
        return this.infinitive;
    }
    String getPast(){
        return this.past;
    }
    String getPastParticiple(){
        return this.pastParticiple;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == this){
            return true;
        }

        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }

        IrregularVerb irrVerb = (IrregularVerb)obj;

        return irrVerb.getInfinitive().equals(this.infinitive) && irrVerb.getPast().equals(this.past)
                && irrVerb.getPastParticiple().equals(this.pastParticiple);
    }
}
