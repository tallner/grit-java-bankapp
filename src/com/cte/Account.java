package com.cte;

import java.util.List;

public class Account {
    private float balance;
    private long accountNr;
    private String type;
    float interestRate;

    public Account(String type) {
        this.type = type;
    }

    public void createAccount() {
        this.accountNr = 4343L;//autogenerate accountnr
    }

    public long getAccountNr() {
        return accountNr;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public float getInterestRate(){
        return interestRate;
    }
    public void setInterestRate(float rate) {
        interestRate = rate;
    }

    public void deposit(float amount) {
        this.balance += amount;
    }
    public boolean withdraw(float amount) {
        if (amount >= balance) this.balance -= amount;
        return (amount >= balance);
    }
    public float getBalance() {
        return balance;
    }
}
