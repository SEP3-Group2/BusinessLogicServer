package com.sep3group2.test;

import com.sep3group2.networking.Client;
import com.sep3group2.networking.SocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import transferobjects.EmployeeUser;

@RestController
@RequestMapping("/employeeUsers")
public class EmployeeUserController
{
    private Client socketClient;

    @Autowired
    public EmployeeUserController()
    {
        this.socketClient = new SocketClient();
    }

    @GetMapping("/{email}")
    public EmployeeUser getUser(@PathVariable String email){
        return socketClient.getEmployeeUser(email);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody EmployeeUser user)
    {
        socketClient.registerEmployee(user);
    }
}
