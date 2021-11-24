package com.cte;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String firstName,lastName;
    private long SSN;
    private List<Account> accounts;
    private List<CreditCard> creditCards;

    public Customer(String firstName, String lastName, long SSN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.accounts = new ArrayList<>();
        this.creditCards = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getSSN() {
        return SSN;
    }
//    public void setSSN(long SSN) {
//        this.SSN = SSN;
//    }

    public List<Account> getAccounts() {
        return accounts;
    }
    public long addAccount(String type, float interestRate){
        Account account = new Account(type, interestRate);

        long nextAccountNr = 1000;
        for (Account value : accounts) {
            //find largest account number
            if (nextAccountNr < value.getAccountNr()) {
                nextAccountNr = value.getAccountNr();
            }
        }
        nextAccountNr += 1;
        account.createAccountNr(nextAccountNr);

        accounts.add(account);

        return nextAccountNr;
    }
    public void deleteAccount(long accountNr){
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNr() == accountNr){
                accounts.remove(i);
                break;
            }
        }
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }
    public long addCreditcard(long SSN, long accountNr){
        CreditCard creditCard = new CreditCard(SSN, accountNr);

        long nextCCNr = 1010_1010_1010_1010L;
        for (CreditCard value : creditCards) {
            //find largest CC number
            if (nextCCNr < value.getCardNr()) {
                nextCCNr = value.getCardNr()*(long)Math.random();
                break;
            }
        }
        creditCard.setCardNr(nextCCNr);
        creditCards.add(creditCard);

        return nextCCNr;
    }
    public void deleteCreditcard(long cardNr){
        for (int i = 0; i < creditCards.size(); i++) {
            if (creditCards.get(i).getCardNr() == cardNr){
                creditCards.remove(i);
                break;
            }
        }
    }

    public void presetAccount(long accountNr, float balance, String type, float interestRate){
        Account account = new Account(type, interestRate, accountNr, balance);

//        long nextAccountNr = 1000;
//        for (Account value : accounts) {
//            //find largest account number
//            if (nextAccountNr < value.getAccountNr()) {
//                nextAccountNr = value.getAccountNr();
//            }
//        }
//        nextAccountNr += 1;
//        account.createAccountNr(nextAccountNr);
//
        accounts.add(account);

    }


}
