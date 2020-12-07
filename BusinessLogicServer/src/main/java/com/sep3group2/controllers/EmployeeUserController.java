package com.sep3group2.controllers;

import com.sep3group2.networking.Client;
import com.sep3group2.networking.SocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import transferobjects.EmployeeUser;

import java.util.List;

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

    @GetMapping("")
    public List<EmployeeUser> getUsers(){
        return socketClient.getAllEmployeeUsers();
    }

    @GetMapping("/users/{id}")
    public EmployeeUser getUser(@PathVariable int id){
        return socketClient.getEmployeeUserByID(id);
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

    @PatchMapping("")
    public EmployeeUser updateUser(@RequestBody EmployeeUser user){
        return socketClient.updateEmployeeUser(user);
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployeeUser(@PathVariable int id){
        socketClient.deleteEmployeeUser(id);
    }
}
