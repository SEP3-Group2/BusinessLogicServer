package com.sep3group2.controllers;

import com.sep3group2.networking.Client;
import com.sep3group2.networking.SocketClient;
import database.warehouseproductDAO.WarehouseProductDAO;
import database.wpJoinDAO.WPJoinDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import transferobjects.WPJoin;
import transferobjects.WarehouseProduct;

import java.util.List;

@RestController
@RequestMapping("/wpjoin")
public class WPJoinController
{
    private WPJoinDAO wpJoinDAO;
    private Client socketClient;

    @Autowired
    public WPJoinController()
    {
        this.socketClient = new SocketClient();
    }

    @GetMapping
    public List<WPJoin> getAllWPJoin()
    {
        return socketClient.getAllWPJoin();
    }

    @GetMapping("/{storeId}")
    public List<WPJoin> getStoreWPJoin(@PathVariable int storeId)
    {
        return socketClient.getStoreWPJoin(storeId);
    }

}