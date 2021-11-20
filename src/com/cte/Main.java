package com.cte;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // main takes care of the terminal and runs the application continuous until exit
        String bankName = "";
        int sel = 666;
        Scanner userSel = new Scanner(System.in);
        Bank bank = new Bank();
        //RecordCatalogue recordCatalogue= new RecordCatalogue();
        //Filehandler filehandler = new Filehandler();


        while(true)
        {
            System.out.println(" |**********************| ");
            System.out.println(" |****     MAIN MENU     ****| ");
            System.out.println(" |**********************| ");
            System.out.println(" 0. List banks "); //list customer files in a certain directory
            System.out.println(" 1. Create new bank "); //setBankName() Generates a new customer list, eg a text file
            System.out.println(" 2. Import customer list"); //getCustomers() Reads a customer list from file
            System.out.println(" 3. Add a customer"); //addCustomer()
            System.out.println(" 4. Remove a customer"); //removeCustomer()

            System.out.println(" 5. Get customer information"); //getCustomer()
            System.out.println(" 6. Change customer name"); //changeCustomerName()
            System.out.println(" 7. Add account to an existing customer");//addAccount()

            System.out.println(" 8. Get account information from an existing customer account");//getAccount()
            System.out.println(" 9. Deposit money to an existing customer account");//deposit()
            System.out.println(" 10. Withdraw money from an existing customer account");//withdraw()
            System.out.println(" 11. Close a customer account");//closeAccount()

            System.out.println(" 100. Exit ");
            System.out.println("....................");
            System.out.println("Make your choice!");
////////////////////////////////////////////////////////////
//            System.out.println(" |**********************| ");
//            System.out.println(" |****     CUSTOMER MENY     ****| ");
//            System.out.println(" |**********************| ");
//
//            System.out.println(" 3. Get customer information");
//            System.out.println(" 4. Change customer name");
//            System.out.println(" 5. Add customer");
//            System.out.println(" 6. Remove customer");
//            System.out.println(" 6. Add account to an existing customer ");
//
//            System.out.println(" 100. Exit ");
//            System.out.println("....................");
//            System.out.println("Make your choice!");
//////////////////////////////////////////////////////////
//            System.out.println(" |**********************| ");
//            System.out.println(" |****     ACCOUNT MENY     ****| ");
//            System.out.println(" |**********************| ");
//            System.out.println(" 0. List banks ");
//            System.out.println(" 1. Create new bank ");
//            System.out.println(" 2. Import customer list");
//            System.out.println(" 3. Get customer information");
//            System.out.println(" 4. Change customer name");
//            System.out.println(" 5. Add customer");
//            System.out.println(" 6. Remove customer");
//            System.out.println(" 6. Add account to an existing customer ");
//
//            System.out.println(" 100. Exit ");
//            System.out.println("....................");
//            System.out.println("Make your choice!");


            //make sure the input is correct
            try {
                sel = userSel.nextInt();
            } catch (Exception e) {
                System.out.println("bad input");
                userSel.next();
            }

            //exit the gradebook app
            if(sel == 100) break;


            //select what action to do
            switch (sel) {
                //list all files/banks in directory
                case 0 -> {
                    System.out.println("Available banks:");
//                    filehandler.listFiles();
                }

                //create a new customer file, eg a new bank
                case 1 -> {
                    System.out.println("Bank name");
                    try {
                        bankName = userSel.next();
                    } catch (Exception e) {
                        System.out.println("bad input");
                        userSel.next();
                    }
                    bank.setBankName(bankName);


 //                   filehandler.createFile(bankName);
                }

                //get customers from an existing bank
                case 2 -> {
                    System.out.println(" |****************************************| ");
                    System.out.println(" |**** List customers ****| ");
                    System.out.println(" |****************************************| ");
//                    System.out.println(" 0. Read gradebook");
//                    System.out.println(" 1. HOME ");

                    System.out.println(bank.getCustomers());

                    //make sure the input is correct
//                    try {
//                        sel = userSel.nextInt();
//                    } catch (Exception e) {
//                        System.out.println("bad input");
//                        userSel.next();
//                    }

//                    switch (sel){
//                        case 0 -> {
//                            System.out.print("Name of gradebook: ");
//                            gradebookName = userSel.next();
//
//                            //read the specified file with the filehandler
//                            try {
//                                //read the students from the file into the catalogue object
//                                recordCatalogue.setStudentList(filehandler.readFile(gradebookName));
//
//                            }
//                            catch (Exception e){
//                                System.out.println("An error occurred.");
//                                e.printStackTrace();
//                            }
//
//                        }
//                        default -> System.out.println("go home") ;
//                    }

                }

                //Add a customer
                case 3 -> {

                    System.out.print("Customer first name: ");
                    String firstName = userSel.next();
                    System.out.print("Customer last name: ");
                    String lastName = userSel.next();
                    System.out.print("Customer SSN: ");
                    long SSN = userSel.nextLong();

                    System.out.println(bank.addCustomer(firstName,lastName,SSN));
                    //add both to the object and the file so that you dont need to read the file again or loose if restarting
//                    recordCatalogue.addStudent(name,SSN,grade,course);
//                    filehandler.writeNewStudentTofile(name,SSN,grade,gradebookName);

                }

                //Remove a customer
                case 4 -> {
                    System.out.print("Customer SSN: ");
                    long SSN = userSel.nextLong();

                    System.out.println(bank.removeCustomer(SSN));
                }
//
//                //read statistics
//                case 3 -> {
//                    if (recordCatalogue.studentList.size()==0)
//                        System.out.println("No gradebook selected");
//                    else {
//                        System.out.println("Average grade for all students are " + recordCatalogue.getAverageGrade());
//                        System.out.println("Highest grade among all students are " + recordCatalogue.getHighestGrade());
//                        System.out.println("Lowest grade among all students are " + recordCatalogue.getLowestGrade());
//                    }
//
//                }
//
//                //select a student
//                case 4 -> {
//                    System.out.print("Student name: ");
//                    String name = userSel.next();
//                    String grade = recordCatalogue.findStudent(name);
//
//                    if (grade.equals("666")) System.out.println("Student not found");
//                    else System.out.println(name + "´s grades:" + System.lineSeparator() + grade);
//                }

                //add a customer


                //Get a certain customers information
                case 5 -> {
                    System.out.print("Customer SSN: ");
                    long SSN = userSel.nextLong();

                    System.out.println(bank.getCustomer(SSN));

                }

                //Change customer name
                case 6 -> {
                    System.out.print("Customer first name: ");
                    String firstName = userSel.next();
                    System.out.print("Customer last name: ");
                    String lastName = userSel.next();
                    System.out.print("Customer SSN: ");
                    long SSN = userSel.nextLong();

                    if (bank.changeCustomerName(firstName, lastName, SSN)) System.out.println("Customer name changed");
                    else {System.out.println("Customer "+SSN+" does not exist");}
                }

                //Add account to an existing customer
                case 7 -> {
                    System.out.print("Customer SSN: ");
                    long SSN = userSel.nextLong();
                    System.out.print("Account type: ");
                    String accountType = userSel.next();
                    System.out.print("Interest rate: ");
                    float interestRate = userSel.nextFloat();

                    System.out.println(bank.addAccount(SSN,accountType,interestRate));

                    //add both to the object and the file so that you dont need to read the file again or loose if restarting
//                    recordCatalogue.addGradeToStudent(name,grade,course);
//                    filehandler.writeStudentsToFile(recordCatalogue,gradebookName);


                }



                //Get account information from an existing customer account
                case 8 -> {
                    System.out.print("Customer SSN: ");
                    long SSN = userSel.nextLong();
                    System.out.print("Account number: ");
                    long accountNr = userSel.nextLong();

                    System.out.println(bank.getAccount(SSN, accountNr));

                }

                //Deposit money to an existing customer account
                case 9 -> {
                    System.out.print("Customer SSN: ");
                    long SSN = userSel.nextLong();
                    System.out.print("Account number: ");
                    long accountNr = userSel.nextLong();
                    System.out.print("Deposit amount: ");
                    int amount = userSel.nextInt();

                    System.out.println(bank.deposit(SSN,accountNr,amount));

                }

                //Withdraw money from an existing customer account
                case 10 -> {
                    System.out.print("Customer SSN: ");
                    long SSN = userSel.nextLong();
                    System.out.print("Account number: ");
                    long accountNr = userSel.nextLong();
                    System.out.print("Withdraw amount: ");
                    int amount = userSel.nextInt();

                    System.out.println(bank.withdraw(SSN,accountNr,amount));


                }

                //Close a customer account
                case 11 -> {
                    System.out.print("Customer SSN: ");
                    long SSN = userSel.nextLong();
                    System.out.print("Account number: ");
                    long accountNr = userSel.nextLong();

                    System.out.println(bank.closeAccount(SSN,accountNr));


                }

                default -> System.out.println("0");
            }
        }

    }
}
