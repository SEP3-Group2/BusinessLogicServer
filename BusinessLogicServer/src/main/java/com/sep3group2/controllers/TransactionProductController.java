package com.sep3group2.controllers;

import com.sep3group2.networking.Client;
import com.sep3group2.networking.SocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import transferobjects.HistoryProduct;
import transferobjects.Transaction;
import transferobjects.TransactionProduct;

import java.util.List;

@RestController
@RequestMapping("/transactionProduct")
public class TransactionProductController
{
  private Client socketClient;

  @Autowired
  public TransactionProductController()
  {
    this.socketClient = new SocketClient();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public TransactionProduct AddTransactionProduct(@RequestBody TransactionProduct transactionProduct){

    return socketClient.addTransactionProduct(transactionProduct);
  }

  @GetMapping("/{transid}")
  public List<HistoryProduct> getTransProById(@PathVariable int transid){
    return socketClient.getTransProById(transid);
  }
}
