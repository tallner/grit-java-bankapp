# grit-java-bankapp
final project in the basic java course. fictive bank app

How to use

Not much error handling is implemented, the app needs to be used in correct order.  
Start with either create a new banklist or select an already existing, for example the mockData that is created when the app is launched.  
If you select an existing file, customers needs to have at least on account.  
  
File needs to follow this pattern:  
Customer1FirstName Customer1LastName Customer1SSN : accountNumber1 accountType interestRate balance , accountNumber2 accountType interestRate balance , accountNumber3 credit interestRate balance  
Customer2FirstName Customer2LastName Customer2SSN : accountNumber1 accountType interestRate balance , accountNumber2 accountType interestRate balance  
...  
CustomerNFirstName CustomerNLastName CustomerNSSN : accountNumber1 accountType interestRate balance , accountNumber2 accountType interestRate balance ... accountNumberN accountType interestRate balance  
  
  
All actions in the menu that changes any account also writes to the account file.  

-- MENU --
0. List banks --> list bank files in a certain directory  
1. Create new bank --> Generates a new customer list, eg a text file  
2. Import customer list --> Reads a customer list from file  
3. Add a customer --> adds a customer to selected   
4. Remove a customer --> Removes a customer  
  

5. Get customer information --> Get information about a certain customer
6. Change customer name --> Change a customers name
7. Add account to an existing customer --> Add account to a customer
   

8. Get account information from an existing customer account -->  
9. Deposit money to an existing customer account -->  
10. Withdraw money from an existing customer account -->  
11. Close a customer account -->   

