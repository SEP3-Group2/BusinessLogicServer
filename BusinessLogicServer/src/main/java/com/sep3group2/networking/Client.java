package com.sep3group2.networking;

import org.springframework.web.bind.annotation.PathVariable;
import transferobjects.*;

import java.util.List;

public interface Client
{
    List<Product> getAllProducts();
    Product getProductById(int id);
    List<Product> getTitleCategoryFilteredProducts(String title,String category);
    List<Product> getTitleCategoryPriceFilteredProducts(String title,String category,String price);

    Product addProduct(String title, String category, String description, double price);

    void registerCustomer(CustomerUser user);
    void registerEmployee(EmployeeUser user);
    List<CustomerUser> getAllUsers();

    void startClient();

    CustomerUser getCustomerUser(String email);

    EmployeeUser getEmployeeUser(String email);
    List<WarehouseProduct> getAllWarehouseProducts();
    List<WarehouseProduct> getStoreWarehouseProducts(int storeid);
    WarehouseProduct addWarehouseProduct(int storeid, int productid, int quantity);
    int getLastProductID(int id);
    int getLastTransactionID(int id);

    List<CartProduct> GetCartProducts(int productid, int quantity);
    List<CartProduct> GetNotEnoughCartProducts(int productid, int quantity);

    Transaction addTransaction(Transaction transaction);
    TransactionProduct addTransactionProduct(TransactionProduct transactionProduct);
    List<Transaction> getTransactionsByEmail( String email);

    List<WPJoin> getAllWPJoin();
    List<WPJoin> getStoreWPJoin(int storeid);
    void orderProductFromManufacturer(OrderProduct orderProduct);
    void orderProductFromStore(OrderProduct orderProduct);
    void decrementProductQuantity(OrderProduct orderProduct);

    List<HistoryProduct> getTransProById(int transid);
}
