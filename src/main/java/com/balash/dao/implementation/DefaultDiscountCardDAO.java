package com.balash.dao.implementation;

import com.balash.bean.DiscountCard;
import com.balash.dao.DiscountCardDAO;

import java.util.HashMap;
import java.util.Map;

public class DefaultDiscountCardDAO implements DiscountCardDAO {

    private Map<Long, DiscountCard> discountCards;

    public DefaultDiscountCardDAO(){
        discountCards = new HashMap<>();
        DiscountCard discountCardOne = new DiscountCard();
        discountCardOne.setId(1L);
        discountCardOne.setDiscount(1);
        discountCards.put(discountCardOne.getId(),discountCardOne);
        DiscountCard discountCardTwo = new DiscountCard();
        discountCardTwo.setId(2L);
        discountCardTwo.setDiscount(2);
        discountCards.put(discountCardTwo.getId(),discountCardTwo);
        DiscountCard discountCardThree = new DiscountCard();
        discountCardThree.setId(3L);
        discountCardThree.setDiscount(3);
        discountCards.put(discountCardThree.getId(),discountCardThree);
    }

    @Override
    public DiscountCard getDiscountCardById(long id) {
        return null;
    }
}
