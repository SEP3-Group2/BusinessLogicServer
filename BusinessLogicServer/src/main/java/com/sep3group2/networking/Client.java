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
    List<WarehouseProduct> getWarehouseProductFromStoresById(WarehouseProduct warehouseProduct);
    void modifyProduct(Product product);

    List<HistoryProduct> getTransProById(int transid);

    List<EmployeeUser> getAllEmployeeUsers();

    EmployeeUser getEmployeeUserByID(int id);

    EmployeeUser updateEmployeeUser(EmployeeUser user);

    void deleteEmployeeUser(int id);

    CustomerUser getCustomerById(int id);
    CustomerUser updateCustomerInfo(CustomerUser customerUser);
    List<Rating> getAllRatings();
    void addRating(Rating rating);
    List<DidUserBuyJoin> didUserBuyThisProduct(String email);

  List<ReserveHistory> getAllReserveHistory();
    List<ReserveHistory> getReserveHistoryByStoreEmail(int storeid, String email);
    List<ReserveHistory> getReserveHistoryByStoreEmailDelivery(int storeid, String email, String deliverymethod);
    WarehouseProduct UpdateWarehouseQuantity(int storeid, int productid, int quantity);
    Transaction UpdateTransactionToReady(int id);
    Transaction UpdateTransactionToDelivered(int id);
}
