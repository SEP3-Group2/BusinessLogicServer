package com.sep3group2.networking;

import transferobjects.Hello;
import transferobjects.Product;

import java.util.List;

public interface Client
{
    Hello getHello();
    List<Product> getAllProducts();
    Product addProduct(String title, String category, String description, double price);

    void startClient();
}
