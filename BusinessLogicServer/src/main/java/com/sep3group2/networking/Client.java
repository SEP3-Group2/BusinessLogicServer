package com.sep3group2.networking;

import transferobjects.CustomerUser;
import transferobjects.Hello;
import transferobjects.Product;
import transferobjects.EmployeeUser;

import java.util.List;

public interface Client
{
    Hello getHello();
    List<Product> getAllProducts();
    Product addProduct(String title, String category, String description, double price);

    void registerCustomer(CustomerUser user);
    void registerEmployee(EmployeeUser user);
    List<CustomerUser> getAllUsers();

    void startClient();

    CustomerUser getCustomerUser(String email);

    EmployeeUser getEmployeeUser(String email);
}
