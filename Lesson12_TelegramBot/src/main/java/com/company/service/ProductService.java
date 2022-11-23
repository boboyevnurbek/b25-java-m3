package com.company.service;

import com.company.db.Database;
import com.company.entity.Category;
import com.company.entity.Product;

public class ProductService {
    public static String addProduct(Product product) {

        Integer id = Database.PRODUCT_LIST.isEmpty() ? 1 :
                Database.PRODUCT_LIST.get(Database.PRODUCT_LIST.size()-1).getId()+1;

        product.setId(id);
        Database.PRODUCT_LIST.add(product);

        return product.getName()+" successfully added";
    }
}
