package com.sep3group2.controllers;

import com.sep3group2.networking.Client;
import com.sep3group2.networking.SocketClient;
import database.productDAO.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import transferobjects.Hello;
import transferobjects.Product;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController
{
    private ProductDAO productDAO;
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

    @GetMapping
    public List<Product> getAllProducts(){
        return socketClient.getAllProducts();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product AddProduct(@RequestBody Product product){

      return socketClient.addProduct(product.getTitle(),product.getCategory(), product.getDescription(), product.getPrice());


    }
}
