package org.example.LLD.InventoryManagement;

import org.example.LLD.InventoryManagement.Product.ProductFactory;
import org.example.LLD.InventoryManagement.Replenish.ReplenishmentStrategy;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private static InventoryManager inventoryManager;
    private ProductFactory productFactory;
    private List<Warehouse> warehouseList;
    private ReplenishmentStrategy replenishmentStrategy;

    private InventoryManager() {
        warehouseList = new ArrayList<>();
        productFactory = new ProductFactory();
    }

    public static synchronized InventoryManager getInstance(){
        if(inventoryManager != null)
            return inventoryManager;
        return inventoryManager = new InventoryManager();
    }

    public void addWareHouse(Warehouse warehouse){
        this.warehouseList.add(warehouse);
    }
    public void removeWareHouse(Warehouse warehouse){
        this.warehouseList.remove(warehouse);
    }

    public ReplenishmentStrategy getReplenishmentStrategy() {
        return replenishmentStrategy;
    }

    public void setReplenishmentStrategy(ReplenishmentStrategy replenishmentStrategy) {
        this.replenishmentStrategy = replenishmentStrategy;
    }

    
}
