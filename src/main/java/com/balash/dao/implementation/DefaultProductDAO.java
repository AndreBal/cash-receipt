package com.balash.dao.implementation;

import com.balash.bean.Product;
import com.balash.dao.ProductDAO;

import java.util.HashMap;
import java.util.Map;

public class DefaultProductDAO implements ProductDAO {
    private Map<Long,Product> products;

    public DefaultProductDAO(){
        products = new HashMap<>();
        Product first = new Product();
        first.setId(1L);
        first.setName("Necronomicon");
        first.setOnDiscount(false);
        first.setPrice(10000);
        products.put(first.getId(),first);
        Product second = new Product();
        second.setId(2L);
        second.setName("Lament Configuration");
        second.setOnDiscount(true);
        second.setPrice(10);
        products.put(second.getId(),second);
        Product third = new Product();
        third.setId(3L);
        third.setName("Cake");
        third.setOnDiscount(true);
        third.setPrice(431);
        products.put(third.getId(),third);
    }

    @Override
    public Product getProductById(long id){
        return products.get(id);
    }
}
