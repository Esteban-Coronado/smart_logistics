package com.maven_smart_logistics.smart_logistics.model;

import java.util.Date;
import java.util.List;

public class PurchaseFactory {
    public static Purchase createBasicPurchase(List<Product> products, Warehouse warehouse) {
        Purchase purchase = new Purchase();
        purchase.setPurchaseDate(new Date());
        purchase.setStatus("PENDING");
        purchase.setWarehouse(warehouse);
        
        // Calcular cantidad total 
        int totalQuantity = products.stream()
                                 .mapToInt(p -> 1) // 1 unidad por producto
                                 .sum();
        
        purchase.setQuantity(totalQuantity);
        return purchase;
    }
    
    public static Purchase createPurchaseWithProducts(List<Product> products, 
                                                   Warehouse warehouse, 
                                                   String status) {
        Purchase purchase = createBasicPurchase(products, warehouse);
        purchase.setStatus(status);
        return purchase;
    }
}
