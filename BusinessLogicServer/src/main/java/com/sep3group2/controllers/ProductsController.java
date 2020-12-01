package com.sep3group2.controllers;

import com.sep3group2.networking.Client;
import com.sep3group2.networking.SocketClient;
import database.productDAO.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public List<Product> getAllProducts(){
        return socketClient.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return socketClient.getProductById(id);
    }

    @GetMapping("/{title}/{category}")
    public List<Product> getTitleCategoryFilteredProducts(@PathVariable String title,@PathVariable String category){
        return socketClient.getTitleCategoryFilteredProducts(title,category);
    }

    @GetMapping("/{title}/{category}/{price}")
    public List<Product> getTitleCategoryPriceFilteredProducts(@PathVariable String title,@PathVariable String category,@PathVariable String price){
        return socketClient.getTitleCategoryPriceFilteredProducts(title,category,price);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product AddProduct(@RequestBody Product product){

      return socketClient.addProduct(product.getTitle(),product.getCategory(), product.getDescription(), product.getPrice());


    }
}
