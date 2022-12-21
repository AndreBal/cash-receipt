package com.balash.service.util;

import com.balash.bean.DiscountCard;
import com.balash.bean.Product;
import com.balash.dao.DiscountCardDAO;
import com.balash.dao.ProductDAO;
import com.balash.dao.implementation.DefaultDiscountCardDAO;
import com.balash.dao.implementation.DefaultProductDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DefaultDiscCardParser {

    DiscountCardDAO discountCardDAO = new DefaultDiscountCardDAO();
    public List<DiscountCard> parseDiscountCards(Map<String, String> args){
        List<DiscountCard> discountCards = new ArrayList<>();
        for(Map.Entry<String, String> entry : args.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if(key.equals("card")){
                DiscountCard discCard = discountCardDAO.getDiscountCardById(Long.parseLong(value));
                discountCards.add(discCard);
            }
        }
        return discountCards;
    }
}
