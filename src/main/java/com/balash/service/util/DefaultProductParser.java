package com.balash.service.util;


import com.balash.bean.Product;
import com.balash.dao.ProductDAO;
import com.balash.dao.implementation.DefaultProductDAO;

import java.util.HashMap;
import java.util.Map;

public class DefaultProductParser {

    ProductDAO productDAO = new DefaultProductDAO();
    public Map<Product,Integer> parseProducts(Map<String, String> args){
        Map<Product,Integer> products = new HashMap<>();
        for(Map.Entry<String, String> entry : args.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if(key.matches("\\d+")) {
                Product product = productDAO.getProductById(Long.parseLong(key));
                products.put(product,Integer.parseInt(value));
            }
        }
        return products;
    }
}
