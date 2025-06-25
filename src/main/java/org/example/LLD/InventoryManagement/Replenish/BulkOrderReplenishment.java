package org.example.LLD.InventoryManagement.Replenish;

import org.example.LLD.InventoryManagement.Product.Product;

public class BulkOrderReplenishment implements ReplenishmentStrategy{
    @Override
    public void replenish(Product product) {
        System.out.println("Bulk order replenished " + product.getName());
    }
}
