package com.sep3group2.controllers;

import com.sep3group2.networking.Client;
import com.sep3group2.networking.SocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import transferobjects.DidUserBuyJoin;
import transferobjects.Rating;
import transferobjects.WarehouseProduct;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    private Client socketClient;

    @Autowired
    public RatingController()
    {
        this.socketClient = new SocketClient();
    }

    @GetMapping
    public List<Rating> getAllRatings(){
        return socketClient.getAllRatings();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void AddWarehouseProduct(@RequestBody Rating rating){

        socketClient.addRating(rating);
    }
    @GetMapping("/{email}")
    public List<DidUserBuyJoin> DidUserBuyThisProduct(@PathVariable String email){
        return socketClient.didUserBuyThisProduct(email);
    }
}
