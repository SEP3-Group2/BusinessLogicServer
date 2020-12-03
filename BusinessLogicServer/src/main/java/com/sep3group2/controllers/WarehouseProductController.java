package com.sep3group2.controllers;

import com.sep3group2.networking.Client;
import com.sep3group2.networking.SocketClient;
import database.warehouseproductDAO.WarehouseProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import transferobjects.CartProduct;
import transferobjects.WarehouseProduct;

import java.util.List;

@RestController
@RequestMapping("/warehouseproducts")
public class WarehouseProductController {
    private Client socketClient;

    @Autowired
    public WarehouseProductController()
    {
        this.socketClient = new SocketClient();
    }
    @GetMapping
    public List<WarehouseProduct> getAllWarehouseProducts(){
        return socketClient.getAllWarehouseProducts();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WarehouseProduct AddWarehouseProduct(@RequestBody WarehouseProduct warehouseProduct){

        return socketClient.addWarehouseProduct(warehouseProduct.getStoreId(), warehouseProduct.getProductId(), warehouseProduct.getQuantity());
    }

    @GetMapping("/{storeid}")
    public List<WarehouseProduct> getStoreWarehouseProducts(@PathVariable int storeid){
        return socketClient.getStoreWarehouseProducts(storeid);
    }

    @GetMapping("/{productid}/{quantity}")
    public List<CartProduct> GetCartProducts(@PathVariable int productid,@PathVariable int quantity){
        return socketClient.GetCartProducts(productid,quantity);
    }

}