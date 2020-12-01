package com.sep3group2.networking;

import transferobjects.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class SocketClient implements Client
{
    @Override
    public List<Product> getAllProducts()
    {
        try
        {
            Request response = request(null, "GetAllProducts");
            return (List<Product>) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public Product getProductById(int id)
    {
        try
        {
            Request response = request(id, "GetProductById");
            return (Product) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public List<Product> getTitleCategoryFilteredProducts(String title, String category)
    {
        try
        {
            String[] requests = {title, category};
            Request response = request(requests, "GetTitleCategoryFilteredProducts");
            return (List<Product>) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public List<Product> getTitleCategoryPriceFilteredProducts(String title, String category,String price)
    {
        try
        {
            String[] requests = {title, category,price};
            Request response = request(requests, "GetTitleCategoryPriceFilteredProducts");
            return (List<Product>) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public Product addProduct(String title, String category,
        String description, double price)
    {
        try
        {
            Product newProduct = new Product(title, category, description, price);
            Request response = request(newProduct, "AddProduct");
            return (Product) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void registerCustomer(CustomerUser user)
    {
        try
        {
            Request response = request(user, "RegisterCustomerUser");
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void registerEmployee(EmployeeUser user)
    {
        try
        {
            Request response = request(user, "RegisterEmployeeUser");
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<CustomerUser> getAllUsers()
    {
        try
        {
            Request response = request(null, "GetAllUsers");
            return (List<CustomerUser>) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CustomerUser getCustomerUser(String email)
    {
        try
        {
            Request response = request(email, "GetCustomerUser");
            return (CustomerUser) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public EmployeeUser getEmployeeUser(String email)
    {
        try
        {
            Request response = request(email, "GetEmployeeUser");
            return (EmployeeUser) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void startClient()
    {
        try
        {
            Socket socket = new Socket("localhost", 2910);
            System.out.println("Connected to server");

            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());

            new Thread(() -> listenToServer(outToServer, inFromServer)).start();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override public int getLastProductID(int id)
    {
        try
        {
            Request response = request(id, "GetLastProductID");
            return (int) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return 0;
    }



    private void listenToServer(ObjectOutputStream outToServer, ObjectInputStream inFromServer)
    {
        try
        {
            outToServer.writeObject(new Request("Listener", null));
            while (true)
            {
                Request request = (Request) inFromServer.readObject();
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private Request request(Object arg, String type) throws IOException, ClassNotFoundException
    {
        Socket socket = new Socket("localhost", 2910);
        ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
        outToServer.writeObject(new Request(type, arg));
        return (Request) inFromServer.readObject();
    }

}
