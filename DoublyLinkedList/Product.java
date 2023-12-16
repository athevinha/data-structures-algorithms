package DataStructures.DoublyLinkedList;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private String material;
    private int manufacturing;
    private int expiry;

    public Product() {
    }

    public Product(int id, String name, String material, int manufacturing, int expiry) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.manufacturing = manufacturing;
        this.expiry = expiry;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getManufacturing() {
        return this.manufacturing;
    }

    public void setManufacturing(int manufacturing) {
        this.manufacturing = manufacturing;
    }

    public int getExpiry() {
        return this.expiry;
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }

    public Product id(int id) {
        setId(id);
        return this;
    }

    public Product name(String name) {
        setName(name);
        return this;
    }

    public Product material(String material) {
        setMaterial(material);
        return this;
    }

    public Product manufacturing(int manufacturing) {
        setManufacturing(manufacturing);
        return this;
    }

    public Product expiry(int expiry) {
        setExpiry(expiry);
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
        return id == product.id && Objects.equals(name, product.name) && Objects.equals(material, product.material) && manufacturing == product.manufacturing && expiry == product.expiry;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, material, manufacturing, expiry);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", material='" + getMaterial() + "'" +
            ", manufacturing='" + getManufacturing() + "'" +
            ", expiry='" + getExpiry() + "'" +
            "}";
    }
}
