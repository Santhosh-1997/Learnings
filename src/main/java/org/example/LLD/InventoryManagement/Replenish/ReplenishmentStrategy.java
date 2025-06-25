package org.example.LLD.InventoryManagement.Replenish;

import org.example.LLD.InventoryManagement.Product.Product;

public interface ReplenishmentStrategy {
    void replenish(Product product);
}
