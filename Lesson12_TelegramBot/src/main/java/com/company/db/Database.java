package com.company.db;

import com.company.entity.*;
import com.company.service.CategoryService;
import com.company.service.CustomerService;
import com.company.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public interface Database {
    List<Category> CATEGORY_LIST = new ArrayList<>();
    List<Product> PRODUCT_LIST = new ArrayList<>();
    List<Customer> CUSTOMER_LIST = new ArrayList<>();
    List<BasketDetail> BASKET_DETAIL_LIST = new ArrayList<>();
    List<Order> ORDER_LIST = new ArrayList<>();
    List<OrderDetail> ORDER_DETAIL_LIST = new ArrayList<>();

    static void loadData(){
        CategoryService.addCategory("Tv");
        CategoryService.addCategory("Phone");
        CategoryService.addCategory("Fridge");
        CategoryService.addCategory("Watch");

        ProductService.addProduct(new Product(null, 2, "Redmi 9", 150d, "Normal phone",
                "AgACAgIAAxkBAAIBdmN9_Qkbd1Qrp_2LIdUVyWJ73IoFAALmvzEb2OXwSz-FGvUN7vgdAQADAgADeAADKwQ"));

        ProductService.addProduct(new Product(null, 1, "LG", 200d, "Normal tv",
                "AgACAgIAAxkBAAIBaWN9_MjrTijCs02iUEhcFmLsQRkFAALjvzEb2OXwS90hN2-QEtAbAQADAgADeAADKwQ"));

        CustomerService.addCustomerByChatId("5606813390");
        CustomerService.addCustomerByChatId("768177376");
        CustomerService.addCustomerByChatId("1586002925");
        CustomerService.addCustomerByChatId("1117887461");
        CustomerService.addCustomerByChatId("1132376865");

    }
}
