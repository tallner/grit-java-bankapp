package com.cte;

import java.io.*;
import java.util.Scanner;

public class Filehandler {
    private File myObj;
    private final String basePath = "./_bankfiles/";

    public Filehandler() {
    }

    public void listFiles(){
        try {

            // create new file
            myObj = new File(basePath);

            // array of files and directory
            String[] paths = myObj.list();


            // for each name in the path array
            for(String path: paths) {

                // prints filename and directory name
                System.out.println(path);
            }

        } catch(Exception e) {
            // if any error occurs
            e.printStackTrace();
        }
    }

    public void createFile(String filename) {
        try {
            myObj = new File(basePath+filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeCustomersToFile(Bank bank, String filename){
        try {
            FileWriter myWriter = new FileWriter(basePath+filename,false);

            for (int i = 0; i < bank.getCustomersAndAccounts().size() ; i++) {
                myWriter.write(bank.getCustomersAndAccounts().get(i) + System.lineSeparator());
                }
                myWriter.close();
                System.out.println("Successfully printed the customerfile.");

            } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public Bank readFile(String filename) {
        try {
            myObj = new File(basePath+filename);
            Scanner myReader = new Scanner(myObj);
            Bank bank = new Bank();

            System.out.println("Customers");

            while (myReader.hasNextLine()) {
                var line = myReader.nextLine();
                var InfoLine = line.split(" : ");
                var NameSSN = InfoLine[0].split(" ");
                var AccountsInfo = InfoLine[1].split(" , ");

                //Handle Name and SSN
                var firstName = NameSSN[0];
                var lastName = NameSSN[1];
                var SSN = Long.parseLong(NameSSN[2]);

                bank.addCustomer(firstName,lastName,SSN);

                //Handle accounts
                for (var acc : AccountsInfo) {
                    var Accounts = acc.split(" ");
                    var accountNr = Long.parseLong(Accounts[0]);
                    var accountType = Accounts[1];
                    var rate = Float.parseFloat(Accounts[2]);
                    var balance = Float.parseFloat(Accounts[3]);
                    bank.presetAccount(SSN, accountType, rate, balance, accountNr);
                }


            }
            myReader.close();
            //System.out.println(bank);
            return bank;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }

    }



}
