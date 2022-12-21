package com.balash.service.util;

import com.balash.bean.DiscountCard;
import com.balash.bean.Product;

import java.util.List;
import java.util.Map;

public class CheckBodyBuilder {
    private static final String CHECK_HEADER = "----------CASH RECEIPT----------\nQTY DESCRIPTION      PRICE TOTAL\n";
    private static final String CHECK_BREAKER = "================================";
    private static final String CHECK_END = "TOTAL                           ";
    private static final Integer QTY_DESCRIPTION_SIZE = 21;
    private static final Integer QTY_DESCRIPTION_PRICE_SIZE = 27;
    public String buildCheckBody(Map<Product,Integer> products, List<DiscountCard> discountCards) {
        StringBuilder check = new StringBuilder(CHECK_HEADER);
        long sum = 0;

        for (Map.Entry<Product, Integer> entry  : products.entrySet()) {
            StringBuilder productStr = new StringBuilder(" ");
            Product product = entry.getKey();
            Integer amount = entry.getValue();

            productStr.append(amount+" ");
            productStr.append(product.getName());
            while(productStr.length()<QTY_DESCRIPTION_SIZE){
                productStr.append(" ");
            }
            long price = product.getPrice();
            productStr.append(getStrPrice(price));
            while(productStr.length()<QTY_DESCRIPTION_PRICE_SIZE){
                productStr.append(" ");
            }
            long allProductsPrice = price*amount;
            productStr.append(getStrPrice(allProductsPrice));
            productStr.append("\n");
            sum+=allProductsPrice;
            check.append(productStr);
        }
        check.append(CHECK_BREAKER);
        for(DiscountCard discountCard : discountCards){
            sum*=(100-discountCard.getDiscount())/100;
            StringBuilder discStr = new StringBuilder("Discont Card "+discountCard.getId());
            check.append(discStr.toString()+ discountCard.getDiscount()+"\n");
        }
        check.append(CHECK_END);
        check.append(sum+"\n");
        return check.toString();
    }

    private String getStrPrice(long amount) {
        long cents = amount % 100;
        long dollars = amount / 100;
        String strCents;
        if (cents <= 9) {
            strCents = 0 + "" + cents;
        } else {
            strCents = "" + cents;
        }
        return "$" + dollars + "." + strCents;
    }
}
