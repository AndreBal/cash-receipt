package com.balash.bean;

public class Product {
    private long id;
    private String name;
    private long price;
    private boolean onDiscount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean isOnDiscount() {
        return onDiscount;
    }

    public void setOnDiscount(boolean onDiscount) {
        this.onDiscount = onDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (getId() != product.getId()) return false;
        if (getPrice() != product.getPrice()) return false;
        if (isOnDiscount() != product.isOnDiscount()) return false;
        return getName() != null ? getName().equals(product.getName()) : product.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (int) (getPrice() ^ (getPrice() >>> 32));
        result = 31 * result + (isOnDiscount() ? 1 : 0);
        return result;
    }
}
