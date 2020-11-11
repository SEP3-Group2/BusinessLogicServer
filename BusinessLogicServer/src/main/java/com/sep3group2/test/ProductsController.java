package com.sep3group2.test;

import com.sep3group2.networking.Client;
import com.sep3group2.networking.SocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import transferobjects.Hello;
import transferobjects.Product;

import java.sql.*;
import java.util.List;

@RestController
public class ProductsController
{
    private Client socketClient;

    @Autowired
    public ProductsController()
    {
        this.socketClient = new SocketClient();
    }

    @GetMapping("/helloNEW")
    public Hello GetHello()
    {
        return socketClient.getHello();
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return socketClient.getAllProducts();
    }
}
