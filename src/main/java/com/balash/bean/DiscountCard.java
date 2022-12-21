package com.balash.bean;

public class DiscountCard {
    private long id;
    private int discount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "DiscountCard{" +
                "id=" + id +
                ", discount=" + discount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiscountCard that = (DiscountCard) o;

        if (getId() != that.getId()) return false;
        return getDiscount() == that.getDiscount();
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getDiscount();
        return result;
    }
}
