package com.cte;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String bankName;
    private List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
    }
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

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<String> getCustomers(){
        List<String> customerList = new ArrayList<>();

        for (Customer customer : customers) {
            customerList.add(
                    customer.getFirstName()
                    + " " +
                    customer.getLastName()
                    + " " +
                    customer.getSSN()
            );
        }
        return customerList;
    }

    public List<String> getCustomersAndAccounts(){
        List<String> customerList = new ArrayList<>();
        String accountInformation = "";

        for (Customer customer : customers) {
            //add account information
            accountInformation = "";
            for (int i = 0; i < customer.getAccounts().size(); i++) {
                accountInformation +=
                        customer.getAccounts().get(i).getAccountNr()
                        + " " +
                        customer.getAccounts().get(i).getType()
                        + " " +
                        customer.getAccounts().get(i).getInterestRate()
                        + " " +
                        customer.getAccounts().get(i).getBalance();
                if(i < (customer.getAccounts().size())-1) accountInformation += " , ";
            }
            customerList.add(
                    customer.getFirstName()
                    + " " +
                    customer.getLastName()
                    + " " +
                    customer.getSSN()
                    + " : " +
                    accountInformation
            );
        }
        return customerList;
    }

    public boolean addCustomer(String firstName, String lastName, long SSN){
        //if customer not found then add the customer
        int customerIndex = findCustomer(SSN);
        if (customerIndex==-1) customers.add(new Customer(firstName,lastName,SSN));
        return (customerIndex==-1);
    }

    public List<String> getCustomer(long SSN){
        //check if customer does not exist
        int customerIndex = findCustomer(SSN);
        if (customerIndex == -1) return null;

        List<String> customerInfo = new ArrayList<>();

        //add customer name
        customerInfo.add("Customer name: "+customers.get(customerIndex).getFirstName()+" "+customers.get(customerIndex).getLastName());

        //add account information
        for (int i = 0; i < customers.get(customerIndex).getAccounts().size(); i++) {
            customerInfo.add(
                "Account number: "+
                customers.get(customerIndex).getAccounts().get(i).getAccountNr()
                +", Balance: "+
                customers.get(customerIndex).getAccounts().get(i).getBalance()
                +", Account type: "+
                customers.get(customerIndex).getAccounts().get(i).getType()
            );
        } return customerInfo;
    }

    public boolean changeCustomerName(String firstName, String lastName, long SSN){
        //check if customer does not exist
        int customerIndex = findCustomer(SSN);
        if (customerIndex == -1) return false;

        //set name if customer found
        customers.get(customerIndex).setFirstName(firstName);
        customers.get(customerIndex).setLastName(lastName);

        return true;
    }

    public List<String> removeCustomer(long SSN){
        //check if customer does not exist
        int customerIndex = findCustomer(SSN);
        if (customerIndex == -1) return null;

        List<String> accountInformation = new ArrayList<>();

        for (int i = 0; i < customers.get(customerIndex).getAccounts().size(); i++) {
            accountInformation.add(
                    "Account number: "+
                    customers.get(customerIndex).getAccounts().get(i).getAccountNr()
                    +", Cashback: "+
                    customers.get(customerIndex).getAccounts().get(i).getBalance()
                    +", Account type: "+
                    customers.get(customerIndex).getAccounts().get(i).getType()
                    +", Interest: "+
                    (customers.get(customerIndex).getAccounts().get(i).getInterestRate() * customers.get(customerIndex).getAccounts().get(i).getBalance())/100
            );
        }


        //remove customer after account is emptied
        customers.remove(customerIndex);


        return accountInformation;
    }

    public long addAccount(long SSN, String accountType, float interestRate){
        int customerIndex = findCustomer(SSN);
        if (customerIndex == -1) return -1;

        return customers.get(customerIndex).addAccount(accountType, interestRate);
    }

    public long addCreditCard(long SSN, long accountNr){
        int customerIndex = findCustomer(SSN);
        if (customerIndex == -1) return -1;

        return customers.get(customerIndex).addCreditcard(SSN, accountNr);
    }

    public boolean presetAccount(long SSN, String accountType, float interestRate, float balance, long accountNr){
        int customerIndex = findCustomer(SSN);
        if (customerIndex == -1) return false;

        customers.get(customerIndex).presetAccount(accountNr, balance, accountType, interestRate);
        return true;
    }

    public String getAccount(long SSN, long accountNr){
        int customerIndex = findCustomer(SSN);
        if (customerIndex == -1) return "Cannot find customer";

        String returnString = "Account does not exist";
        for (int i = 0; i < customers.get(customerIndex).getAccounts().size(); i++) {
            if (customers.get(customerIndex).getAccounts().get(i).getAccountNr()==accountNr){
                returnString =
                        "Account number: "+
                        accountNr
                        +", Balance: "+
                        customers.get(customerIndex).getAccounts().get(i).getBalance()
                        +", Account type: "+
                        customers.get(customerIndex).getAccounts().get(i).getType()
                        +", Interest rate: "+
                        customers.get(customerIndex).getAccounts().get(i).getInterestRate();
            }
        }

        return returnString;
    }

    public boolean deposit(long SSN, long accountNr, int amount){
        //check if customer does not exist
        int customerIndex = findCustomer(SSN);
        if (customerIndex == -1) return false;

        for (int i = 0; i < customers.get(customerIndex).getAccounts().size(); i++) {
            if (customers.get(customerIndex).getAccounts().get(i).getAccountNr() == accountNr) {
                customers.get(customerIndex).getAccounts().get(i).deposit(amount);
            }
        }return true;
    }

    public boolean withdraw(long SSN, long accountNr, int amount){
        //check if customer does not exist
        int customerIndex = findCustomer(SSN);
        if (customerIndex == -1) return false;
        boolean returnVal = false;

        for (int i = 0; i < customers.get(customerIndex).getAccounts().size(); i++) {
            if (customers.get(customerIndex).getAccounts().get(i).getAccountNr() == accountNr) {
                returnVal = customers.get(customerIndex).getAccounts().get(i).withdraw(amount);
            }
        }return returnVal;

    }

    public String closeAccount(long SSN, long accountNr){
        int customerIndex = findCustomer(SSN);
        if (customerIndex == -1) return "Cannot find customer";

        String returnString = "Account does not exist"; //SHOULD BE CHECKED IN CUSTOMER.JAVA INSTEAD
        for (int i = 0; i < customers.get(customerIndex).getAccounts().size(); i++) {

            if (customers.get(customerIndex).getAccounts().get(i).getAccountNr()==accountNr){
                returnString =
                        "Account number: "+
                        accountNr
                        +", Balance: "+
                        customers.get(customerIndex).getAccounts().get(i).getBalance();
                customers.get(customerIndex).deleteAccount(accountNr);
            }
        }
        return returnString;


    }

}
