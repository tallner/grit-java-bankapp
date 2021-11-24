package com.cte;

public class Payment {
    //this is the baseclass for payment
    //there should be basic information and then the different payment methods extends this class

    private String type="";//card(credit, debit etc) ,telephone, facerecognition
    private long SSN;
    private long accountNr;

    public Payment(String type, long SSN, long accountNr) {
        this.type = type;
        this.SSN = SSN;
        this.accountNr = accountNr;
    }


}
