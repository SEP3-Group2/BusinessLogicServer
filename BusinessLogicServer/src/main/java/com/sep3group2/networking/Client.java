package com.sep3group2.networking;

import transferobjects.Hello;
import transferobjects.Product;

import java.util.List;

public interface Client
{
    Hello getHello();
    List<Product> getAllProducts();

    void startClient();
}
