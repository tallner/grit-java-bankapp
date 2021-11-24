package com.cte;

public class CreditCard extends Payment{
    long cardNr;

    public CreditCard(long SSN, long accountNr) {
        super("CreditCard", SSN, accountNr);
    }

    public void setCardNr(long cardNr) {
        this.cardNr = cardNr;
    }

    public long getCardNr() {
        return cardNr;
    }
}
