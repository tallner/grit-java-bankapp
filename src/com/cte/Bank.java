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
        boolean customerAlreadyExist=false;

        for (int i = 0; i < customers.size(); i++) {
            customerAlreadyExist = customers.get(i).getSSN()==SSN;
        }

        if (!customerAlreadyExist){
            customers.add(new Customer(firstName,lastName,SSN));
        }

        return customerAlreadyExist;
    }

    public List<String> getCustomer(long SSN){
        List<String> customerInfo = new ArrayList<>();
        for (int i = 0; i < customers.size() ; i++) {
            if (customers.get(i).getSSN() == SSN){

                customerInfo.add(
                        customers.get(i).getFirstName()
                        +" "+
                        customers.get(i).getLastName());

                for (int j = 0; j < customers.get(i).getAccounts().size(); j++) {
                    customerInfo.add(
                        "Account number: "+
                        customers.get(i).getAccounts().get(j).getAccountNr()
                        +", Balance: "+
                        customers.get(i).getAccounts().get(j).getBalance()
                        +", Account type: "+
                        customers.get(i).getAccounts().get(j).getType()
                    );

                }

            }

        }
        return customerInfo;
    }
//
//    public changeCustomerName(String name, long SSN){
//
//    }
//
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
