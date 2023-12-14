package DataStructures.SingleLinkedList;

import java.util.Objects;

public class Product {
    private String name;
    private double price;
    private int qty;
    

    public Product() {
    }

    public Product(String name, double price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return this.qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Product name(String name) {
        setName(name);
        return this;
    }

    public Product price(double price) {
        setPrice(price);
        return this;
    }

    public Product qty(int qty) {
        setQty(qty);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(name, product.name) && price == product.price && qty == product.qty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, qty);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", price='" + getPrice() + "'" +
            ", qty='" + getQty() + "'" +
            "}";
    }
    
}
