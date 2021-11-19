package com.cte;

import java.util.List;

public class Customer {
    private String firstName,lastName;
    private long SSN;
    private List<Account> accounts;

    public Customer(String firstName, String lastName, long SSN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
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
    public void setSSN(long SSN) {
        this.SSN = SSN;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
    public void addAccount(String type){
        accounts.add(new Account(type));
    }
    public void deleteAccount(long accountNr){
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNr() == accountNr){
                accounts.remove(i);
            }
        }
    }

}
