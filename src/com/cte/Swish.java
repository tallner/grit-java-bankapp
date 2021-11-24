package com.cte;

public class Swish extends Payment{
    private double telephoneNr;

    public Swish(long SSN, long accountNr, double telephoneNr) {
        super("Swish", SSN, accountNr);
        this.telephoneNr = telephoneNr;
    }


}
