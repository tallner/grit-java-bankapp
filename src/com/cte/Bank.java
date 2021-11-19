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
        return (findCustomer(SSN) != -1);
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

    public List<String> removeCustomer(long SSN){
        //check if customer does not exist
        if (findCustomer(SSN) == -1) return null;

        List<String> accountInformation = new ArrayList<>();

        for (int i = 0; i < customers.get(findCustomer(SSN)).getAccounts().size(); i++) {
            accountInformation.add(
                    "Account number: "+
                    customers.get(findCustomer(SSN)).getAccounts().get(i).getAccountNr()
                    +", Cashback: "+
                    customers.get(findCustomer(SSN)).getAccounts().get(i).getBalance()
                    +", Account type: "+
                    customers.get(findCustomer(SSN)).getAccounts().get(i).getType()
                    +", Interest: "+
                    (customers.get(findCustomer(SSN)).getAccounts().get(i).getInterestRate() * customers.get(findCustomer(SSN)).getAccounts().get(i).getBalance())/100
            );
        }


        //remove customer after account is emptied
        customers.remove(findCustomer(SSN));


        return accountInformation;
    }

    public long addAccount(long SSN, String accountType){
        if (findCustomer(SSN) == -1) return -1;

        return customers.get(findCustomer(SSN)).addAccount(accountType);
    }

    public String getAccount(long SSN, long accountNr){
        if (findCustomer(SSN) == -1) return "Cannot find customer";

        String returnString = "Account does not exist";
        for (int i = 0; i < customers.get(findCustomer(SSN)).getAccounts().size(); i++) {
            if (customers.get(findCustomer(SSN)).getAccounts().get(i).getAccountNr()==accountNr){
                returnString =
                        "Account number: "+
                        accountNr
                        +", Balance: "+
                        customers.get(findCustomer(SSN)).getAccounts().get(i).getBalance()
                        +", Account type: "+
                        customers.get(findCustomer(SSN)).getAccounts().get(i).getType()
                        +", Interest rate: "+
                        customers.get(findCustomer(SSN)).getAccounts().get(i).getInterestRate();
            }
        }

        return returnString;
    }

    public boolean deposit(long SSN, int accountNr, int amount){
        //check if customer does not exist
        if (findCustomer(SSN) == -1) return false;

        for (int i = 0; i < customers.get(findCustomer(SSN)).getAccounts().size(); i++) {
            if (customers.get(findCustomer(SSN)).getAccounts().get(i).getAccountNr() == accountNr) {
                customers.get(findCustomer(SSN)).getAccounts().get(i).deposit(amount);
            }
        }return true;
    }

    public boolean withdraw(long SSN, int accountNr, int amount){
        //check if customer does not exist
        if (findCustomer(SSN) == -1) return false;

        for (int i = 0; i < customers.get(findCustomer(SSN)).getAccounts().size(); i++) {
            if (customers.get(findCustomer(SSN)).getAccounts().get(i).getAccountNr() == accountNr) {
                if (customers.get(findCustomer(SSN)).getAccounts().get(i).getBalance() >= amount){
                    customers.get(findCustomer(SSN)).getAccounts().get(i).withdraw(amount);
                } else return false; //not enough cash

            }
        }return true;

    }

    public String closeAccount(long SSN, int accountNr){
        if (findCustomer(SSN) == -1) return "Cannot find customer";

        String returnString = "Account does not exist";
        for (int i = 0; i < customers.get(findCustomer(SSN)).getAccounts().size(); i++) {
            if (customers.get(findCustomer(SSN)).getAccounts().get(i).getAccountNr()==accountNr){
                returnString =
                        "Account number: "+
                        accountNr
                        +", Balance: "+
                        customers.get(findCustomer(SSN)).getAccounts().get(i).getBalance();
            }
        }
        return returnString;


    }


}
