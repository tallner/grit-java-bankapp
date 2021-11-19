package com.cte;


public class Account {
    private float balance;
    private long accountNr;
    private String type;
    float interestRate;

    public Account(String type, float interestRate) {
        this.type = type;
        this.interestRate = interestRate;
    }

    public void createAccountNr(long accountNr) {
        this.accountNr = accountNr;
    }

    public long getAccountNr() {
        return accountNr;
    }
    public String getType() {
        return type;
    }
 //   public void setType(String type) {
 //       this.type = type;
 //   }

    public float getInterestRate(){
        return interestRate;
    }
//    public void setInterestRate(float rate) {
//        interestRate = rate;
//    }

    public void deposit(int amount) {
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
