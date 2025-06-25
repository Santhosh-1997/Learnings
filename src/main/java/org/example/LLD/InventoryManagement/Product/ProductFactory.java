package org.example.LLD.InventoryManagement.Product;

public class ProductFactory {
    public Product createProduct(ProductCategory category, String sku, String name, double price, int quantity, int threshold) {
        switch (category) {
            case ELECTRONICS:
                return new ElectronicProduct(sku, name, price, quantity, null, threshold);
            case CLOTHING:
                return new ClothingProduct(sku, name, price, quantity,null, threshold);
            default:
                throw new IllegalArgumentException(
                        "Unsupported product category: " + category);
        }
    }
}
