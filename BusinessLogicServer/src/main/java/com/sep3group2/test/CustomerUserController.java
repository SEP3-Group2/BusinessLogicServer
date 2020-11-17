package com.sep3group2.test;

import com.sep3group2.networking.Client;
import com.sep3group2.networking.SocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import transferobjects.CustomerUser;

import java.util.List;

@RestController
@RequestMapping("/customerUsers")
public class CustomerUserController
{
    private Client socketClient;

    @Autowired
    public CustomerUserController()
    {
        this.socketClient = new SocketClient();
    }

    @GetMapping
    public List<CustomerUser> getAllUsers(){
        return socketClient.getAllUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody CustomerUser user)
    {
        socketClient.registerCustomer(user);
    }
}
