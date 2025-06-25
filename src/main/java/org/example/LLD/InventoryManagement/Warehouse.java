package org.example.LLD.InventoryManagement;

import org.example.LLD.InventoryManagement.Product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {
    private int id;
    private String name;
    private String location;
    private Map<String, Product> products;

    public Warehouse(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.products = new HashMap<>();
    }

    public void addProduct(Product product, int quantity){
        if(products.containsKey(product.getSku())){
            Product existingProduct = products.get(product.getSku());
            existingProduct.setQuantity(existingProduct.getQuantity() + quantity);
            products.put(existingProduct.getSku(), existingProduct);
        }else{
            product.setQuantity(quantity);
            products.put(product.getSku(), product);
        }
        System.out.println("Products of " + product.getName() + " is added of quantity " + quantity);
    }

    public boolean removeProduct(String sku, int quantity){
        if(!products.containsKey(sku)) {
            System.out.println(sku + " is not found");
            return false;
        }
        Product product = products.get(sku);
        if(quantity < product.getQuantity()){
            System.out.println(sku + " quantity is " + product.getQuantity() + " is less than given " + quantity);
            return false;
        }

        product.setQuantity(product.getQuantity() - quantity);
        return true;
    }

}
