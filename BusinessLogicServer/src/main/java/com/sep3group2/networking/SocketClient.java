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

    @Override
    public List<Product> getTitleCategoryFilteredProducts(String title, String category)
    {
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
    public List<WarehouseProduct> getAllWarehouseProducts() {
        try
        {
            Request response = request(null, "GetAllWarehouseProducts");
            return (List<WarehouseProduct>) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<WarehouseProduct> getStoreWarehouseProducts(int storeid) {
        try
        {
            Request response = request(storeid, "GetStoreWarehouseProduct");
            return (List<WarehouseProduct>) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public WarehouseProduct addWarehouseProduct(int storeid, int productid, int quantity) {
        try
        {
            WarehouseProduct newProduct = new WarehouseProduct(storeid,productid,quantity);
            Request response = request(newProduct, "AddWarehouseProduct");
            return (WarehouseProduct) response.getArg();
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

    @Override public int getLastTransactionID(int id)
    {
        try
        {
            Request response = request(id, "GetLastTransactionID");
            return (int) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    @Override public List<CartProduct> GetCartProducts(int productid,
        int quantity)
    {
        try
        {
            int[] requests = {productid,quantity};
            Request response = request(requests, "GetCartProducts");
            return (List<CartProduct>) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public List<CartProduct> GetNotEnoughCartProducts(int productid,
        int quantity)
    {
        try
        {
            int[] requests = {productid,quantity};
            Request response = request(requests, "GetNotCartProducts");
            return (List<CartProduct>) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public Transaction addTransaction(Transaction transaction)
    {
        try
        {
            Request response = request(transaction, "AddTransaction");
            return (Transaction) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public TransactionProduct addTransactionProduct(
        TransactionProduct transactionProduct)
    {
        try
        {
            Request response = request(transactionProduct, "AddTransactionProduct");
            return (TransactionProduct) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public List<Transaction> getTransactionsByEmail(String email)
    {
        try
        {
            Request response = request(email, "GetTransactionsByEmail");
            return (List<Transaction>) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<WPJoin> getAllWPJoin() {
        try
        {
            Request response = request(null, "GetAllWPJoin");
            return (List<WPJoin>) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<WPJoin> getStoreWPJoin(int storeid) {
        try
        {
            Request response = request(storeid, "GetStoreWPJoin");
            return (List<WPJoin>) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void orderProductFromManufacturer(OrderProduct orderProduct) {
        try
        {
            Request response = request(orderProduct, "OrderProductFromManufacturer");
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void orderProductFromStore(OrderProduct orderProduct) {
        try
        {
            Request response = request(orderProduct, "OrderProductFromStore");
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void decrementProductQuantity(OrderProduct orderProduct) {
        try
        {
            Request response = request(orderProduct, "DecrementProductQuantity");
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<WarehouseProduct> getWarehouseProductFromStoresById(WarehouseProduct warehouseProduct) {
        try
        {
            Request response = request(warehouseProduct, "GetWarehouseProductFromStoresById");
            return  (List<WarehouseProduct>)response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }


    @Override public List<HistoryProduct> getTransProById(int transid)
    {
        try
        {
            Request response = request(transid, "GetHistoryProducts");
            return (List<HistoryProduct>) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public CustomerUser getCustomerById(int id)
    {
        try
        {
            Request response = request(id, "GetCustomerById");
            return (CustomerUser) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }


    @Override public CustomerUser updateCustomerInfo(CustomerUser customerUser)
    {
        try
        {
            Request response = request(customerUser,"UpdateCustomerInfo");
            return (CustomerUser) response.getArg();

        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;

    }

    @Override public List<ReserveHistory> getAllReserveHistory()
    {
        try
        {
            Request response = request(null, "GetAllReserveHistory");
            return (List<ReserveHistory>) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public List<ReserveHistory> getReserveHistoryByStoreEmail(
        int storeid, String email)
    {
        try
        {
            String[] requests = {String.valueOf(storeid),email};
            Request response = request(requests, "GetReserveHistoryByStoreEmail");
            return (List<ReserveHistory>) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public List<ReserveHistory> getReserveHistoryByStoreEmailDelivery(
        int storeid, String email, String deliverymethod)
    {
        try
        {
            String[] requests = {String.valueOf(storeid),email,deliverymethod};
            Request response = request(requests, "getReserveHistoryByStoreEmailDelivery");
            return (List<ReserveHistory>) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public WarehouseProduct UpdateWarehouseQuantity(int storeid,
        int productid, int quantity)
    {
        try
        {
            int[] requests = {storeid,productid,quantity};
            Request response = request(requests,"UpdateWarehouseQuantity");
            return (WarehouseProduct) response.getArg();

        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public Transaction UpdateTransactionToReady(int id)
    {
        try
        {
            Request response = request(id,"UpdateTransactionToReady");
            return (Transaction) response.getArg();

        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public Transaction UpdateTransactionToDelivered(int id)
    {
        try
        {
            Request response = request(id,"UpdateTransactionToDelivered");
            return (Transaction) response.getArg();

        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Rating> getAllRatings() {
        try
        {
            Request response = request(null, "GetAllRatings");
            return (List<Rating>) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addRating(Rating rating) {

        try
        {
            Request response = request(rating, "AddRating");
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<DidUserBuyJoin> didUserBuyThisProduct(String email) {
        try
        {
            Request response = request(email, "DidUserBuyThisProduct");
            return (List<DidUserBuyJoin>) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<EmployeeUser> getAllEmployeeUsers()
    {
        try
        {
            Request response = request(null, "GetAllEmployeeUsers");
            return (List<EmployeeUser>) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public EmployeeUser getEmployeeUserByID(int id)
    {
        try
        {
            Request response = request(id, "GetEmployeeByID");
            return (EmployeeUser) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public EmployeeUser updateEmployeeUser(EmployeeUser user)
    {
        try
        {
            Request response = request(user, "UpdateEmployeeUser");
            return (EmployeeUser) response.getArg();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void modifyProduct(Product product) {
        try
        {
            Request response = request(product, "ModifyProduct");
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void deleteEmployeeUser(int id)
    {
        try
        {
            request(id, "DeleteEmployeeUser");
        }
        catch (IOException | ClassNotFoundException e)
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
