package com.cte;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String bankName;
    private List<Customer> customers;


    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    //returns the customer index if found, else -1
    private int findCustomer(long SSN){
        //returns the customer index if found, else -1
        int customerIndex=-1;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getSSN()==SSN){
                customerIndex = i;
            }
        }
        return customerIndex;
    }

    public List<String> getCustomers(){
        List<String> customerList = new ArrayList<>();

        for (int i = 0; i < customers.size(); i++) {
            customerList.add(
                    customers.get(i).getFirstName()
                    +" "+
                    customers.get(i).getLastName()
                    +" : "+
                    customers.get(i).getSSN()
            );
        }
        return customerList;

    }

    public boolean addCustomer(String firstName, String lastName, long SSN){
        if (findCustomer(SSN) != -1) customers.add(new Customer(firstName,lastName,SSN));
        return findCustomer(SSN) != -1;
    }

    public List<String> getCustomer(long SSN){
        //check if customer does not exist
        if (findCustomer(SSN) == -1) return null;

        List<String> customerInfo = new ArrayList<>();

        //add customer name
        customerInfo.add("Customer name: "+customers.get(findCustomer(SSN)).getFirstName()+" "+customers.get(findCustomer(SSN)).getLastName());

        //add account information
        for (int i = 0; i < customers.get(findCustomer(SSN)).getAccounts().size(); i++) {
            customerInfo.add(
                "Account number: "+
                customers.get(findCustomer(SSN)).getAccounts().get(i).getAccountNr()
                +", Balance: "+
                customers.get(findCustomer(SSN)).getAccounts().get(i).getBalance()
                +", Account type: "+
                customers.get(findCustomer(SSN)).getAccounts().get(i).getType()
            );
        } return customerInfo;
    }

    public boolean changeCustomerName(String firstName, String lastName, long SSN){
        //check if customer does not exist
        if (findCustomer(SSN) == -1) return false;

        //set name if customer found
        customers.get(findCustomer(SSN)).setFirstName(firstName);
        customers.get(findCustomer(SSN)).setLastName(lastName);

        return true;
    }

//    public removeCustomer(long SSN){
//
//    }
//
//    public addAccount(long SSN){
//
//    }
//
//    public getAccount(long SSN, int accountNr){
//
//    }
//
//    public deposit(long SSN, int accountNr, int amount){
//
//    }
//
//    public withdraw(long SSN, int accountNr, int amount){
//
//    }
//
//    public closeAccount(long SSN, int accountNr){
//
//    }


}
