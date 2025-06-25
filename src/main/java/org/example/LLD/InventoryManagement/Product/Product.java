package org.example.LLD.InventoryManagement.Product;

public abstract class Product {
    private String sku;
    private String name;
    private double price;
    private long quantity;
    private ProductCategory productCategory;
    private int threshold;

    public Product(String sku, String name, double price, long quantity, ProductCategory productCategory, int threshold) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.productCategory = productCategory;
        this.threshold = threshold;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
}
