package com.sep3group2.networking;

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

    List<CartProduct> GetCartProducts(int productid, int quantity);

    Transaction addTransaction(Transaction transaction);

    List<WPJoin> getAllWPJoin();
    List<WPJoin> getStoreWPJoin(int storeid);
    void orderProductFromManufacturer(OrderProduct orderProduct);
    void orderProductFromStore(OrderProduct orderProduct);
    void decrementProductQuantity(OrderProduct orderProduct);

}
