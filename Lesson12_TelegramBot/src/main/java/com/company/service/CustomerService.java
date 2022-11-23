package com.company.service;

import com.company.db.Database;
import com.company.entity.Customer;

public class CustomerService {
    public static void addCustomerByChatId(String chatId) {

        if(getCustomerByChatId(chatId) == null){
            Database.CUSTOMER_LIST.add(new Customer(chatId));
        }
    }

    public static Customer getCustomerByChatId(String chatId) {

        return Database.CUSTOMER_LIST.stream()
                .filter(customer -> customer.getChatId().equals(chatId))
                .findFirst().orElse(null);
    }

}
