package com.sep3group2.controllers;

import com.sep3group2.networking.Client;
import com.sep3group2.networking.SocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import transferobjects.Transaction;
import transferobjects.WarehouseProduct;

@RestController
@RequestMapping("/transaction")
public class TransactionController
{
  private Client socketClient;

  @Autowired
  public TransactionController()
  {
    this.socketClient = new SocketClient();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Transaction AddTransaction(@RequestBody Transaction transaction){

    return socketClient.addTransaction(transaction);
  }
}