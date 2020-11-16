package com.sep3group2.networking;

import transferobjects.Hello;
import transferobjects.Product;
import transferobjects.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class SocketClient implements Client
{
    @Override
    public Hello getHello()
    {
        try
        {
            Request response = request(null, "GetHello");
            return (Hello) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

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
