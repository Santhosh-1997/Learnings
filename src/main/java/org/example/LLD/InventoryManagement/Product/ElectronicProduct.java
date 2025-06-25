package org.example.LLD.InventoryManagement.Product;

public class ElectronicProduct extends Product {
    private String brand;
    private int warrantyMonths;

    public ElectronicProduct(String sku, String name, double price, long quantity, ProductCategory productCategory, int threshold) {
        super(sku, name, price, quantity, ProductCategory.ELECTRONICS, threshold);

    }
}
