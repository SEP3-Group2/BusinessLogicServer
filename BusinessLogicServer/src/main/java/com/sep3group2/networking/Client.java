package com.sep3group2.networking;

import transferobjects.CustomerUser;
import transferobjects.Hello;
import transferobjects.Product;
import transferobjects.EmployeeUser;

import java.util.List;

public interface Client
{
    List<Product> getAllProducts();
    Product getProductById(int id);
    List<Product> getTitleCategoryFilteredProducts(String title,String category);
    List<Product> getTitleCategoryPriceFilteredProducts(String title,String category,String price);

    Product addProduct(String title, String category, String description, double price);

    void registerCustomer(CustomerUser user);
    void registerEmployee(EmployeeUser user);
    List<CustomerUser> getAllUsers();

    void startClient();

    CustomerUser getCustomerUser(String email);

    EmployeeUser getEmployeeUser(String email);
}
