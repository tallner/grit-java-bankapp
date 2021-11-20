package com.cte;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String firstName,lastName;
    private long SSN;
    private List<Account> accounts;

    public Customer(String firstName, String lastName, long SSN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.accounts = new ArrayList<>();
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


}
