package org.example.LLD.InventoryManagement.Product;

public class ClothingProduct extends Product {
    private String size;
    private String color;

    public ClothingProduct(String sku, String name, double price, long quantity, ProductCategory productCategory, int threshold) {
        super(sku, name, price, quantity, ProductCategory.CLOTHING, threshold);
    }
}
