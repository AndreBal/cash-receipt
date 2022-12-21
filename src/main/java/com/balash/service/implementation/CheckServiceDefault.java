package com.balash.service.implementation;

import com.balash.bean.DiscountCard;
import com.balash.bean.Product;
import com.balash.service.CheckService;
import com.balash.service.util.CheckBodyBuilder;
import com.balash.service.util.DefaultDiscCardParser;
import com.balash.service.util.DefaultProductParser;

import java.util.List;
import java.util.Map;

public class CheckServiceDefault implements CheckService {

    @Override
    public void printCheck(Map<String, String> args) {

        Map<Product,Integer> products = new DefaultProductParser().parseProducts(args);
        List<DiscountCard> discountCards = new DefaultDiscCardParser().parseDiscountCards(args);

        String check = new CheckBodyBuilder().buildCheckBody(products,discountCards);
    }
}
