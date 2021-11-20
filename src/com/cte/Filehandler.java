package com.cte;

//import java.io.File;  // Import the File class
//import java.io.IOException;  // Import the IOException class to handle errors
import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
//
//    public void writeNewStudentTofile(String name, long SSN, int grade, String filename){
//        try {
//            FileWriter myWriter = new FileWriter(basePath+filename,true);
//            myWriter.write(System.lineSeparator());
//            myWriter.write(name + System.lineSeparator());
//            myWriter.write(SSN + System.lineSeparator());
//            myWriter.write( Integer.toString(grade) );
//
//            myWriter.close();
//            System.out.println("Successfully added to the gradebook.");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }
//
//    public void writeStudentsToFile(RecordCatalogue recordCatalogue, String filename){
//        try {
//            FileWriter myWriter = new FileWriter(basePath+"TEST.txt",false);
//            ArrayList<Student> students = recordCatalogue.getStudentList();
//            //students = recordCatalogue.getStudentList();
//
//            for (int i = 0; i < students.size() ; i++) {
//                myWriter.write(students.get(i).getName() + System.lineSeparator());
//                myWriter.write(students.get(i).getSSN() + System.lineSeparator());
//
//                for (int j = 0; j < students.get(i).getRecordbook().size(); j++) {
//                    myWriter.write(students.get(i).getRecordbook().get(j).getCourse() + System.lineSeparator());
//                    myWriter.write(students.get(i).getRecordbook().get(j).getGrade() + System.lineSeparator());
//
//                    if ((students.get(i).getRecordbook().size() > 1) && (j<(students.get(i).getRecordbook().size())-1)) {
//                        myWriter.write("newcourse" + System.lineSeparator());
//                    }
//                }
//                myWriter.write("/" + System.lineSeparator());
//
//            }
//
//            myWriter.close();
//            System.out.println("Successfully printed the gradebook.");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }

    public Bank readFile(String filename) {
        try {
            myObj = new File(basePath+filename);
            Scanner myReader = new Scanner(myObj);
            Bank bank = new Bank();

            System.out.println("Customers");

            while (myReader.hasNextLine()) {
                System.out.println("-----------------------------");
                var line = myReader.nextLine();
                var InfoLine = line.split(" : ");
                var NameSSN = InfoLine[0].split(" ");
                var AccountsInfo = InfoLine[1].split(" , ");
                //var Accounts = AccountsInfo[0].split(" ");

                //Handle Name and SSN
                var firstName = NameSSN[0];
                System.out.println(firstName);
                var lastName = NameSSN[1];
                System.out.println(lastName);
                var SSN = Long.parseLong(NameSSN[2]);
                System.out.println(SSN);
                bank.addCustomer(firstName,lastName,SSN);

                //Handle accounts
                for (var acc : AccountsInfo) {
                    var Accounts = acc.split(" ");

                    var accountNr = Long.parseLong(Accounts[0]);
                    System.out.println(accountNr);
                    var accountType = Accounts[1];
                    System.out.println(accountType);
                    var rate = Float.parseFloat(Accounts[2]);
                    System.out.println(rate);
                    var balance = Float.parseFloat(Accounts[3]);
                    System.out.println(balance);
                    bank.presetAccount(SSN, accountType, rate, balance, accountNr);
                }


            }
            myReader.close();
            System.out.println(bank);
            return bank;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }

    }



}
