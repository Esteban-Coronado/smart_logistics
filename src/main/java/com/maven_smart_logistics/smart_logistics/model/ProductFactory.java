package com.maven_smart_logistics.smart_logistics.model;

public class ProductFactory {
    public static Product createBasicProduct(String name, double price, Warehouse warehouse) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setWarehouse(warehouse);
        product.setDescription("Producto estándar");
        return product;
    }
    
    public static Product createProductWithDescription(String name, double price, 
                                                     String description, Warehouse warehouse) {
        Product product = createBasicProduct(name, price, warehouse);
        product.setDescription(description);
        return product;
    }
}