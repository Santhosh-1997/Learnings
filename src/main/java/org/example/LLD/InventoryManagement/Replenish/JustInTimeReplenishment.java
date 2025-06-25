package org.example.LLD.InventoryManagement.Replenish;

import org.example.LLD.InventoryManagement.Product.Product;

public class JustInTimeReplenishment implements ReplenishmentStrategy{
    @Override
    public void replenish(Product product) {
        System.out.println("Applying just in time replensihment for product " + product.getName());
    }
}
