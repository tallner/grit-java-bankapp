package com.cte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MockingData {
    public static Collection<Customer> Customers = new ArrayList<>();

    public static void loadCustomerAndAccounts(){
        var c1 = new Customer("FirstName1", "LastName1", 19990101);
        var c2 = new Customer("FirstName2", "LastName2", 19990202);
        var c3 = new Customer("FirstName3", "LastName3", 19990303);

        c1.addAccount("credit",1.4F);
        c2.addAccount("credit",1.4F);
        c3.addAccount("credit",1.4F);

        List<Customer> customers = new ArrayList<>()
        {
            {
                add(c1);
                add(c2);
                add(c3);
            }
        };
        // List<Customer> customers = new ArrayList<>(Arrays.asList(c1,c2,c3));


        Customers.addAll(customers);

    }
}