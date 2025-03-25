package com.maven_smart_logistics.smart_logistics.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.maven_smart_logistics.smart_logistics.repository.StockRepository;
import com.maven_smart_logistics.smart_logistics.repository.ProductRepository;
import com.maven_smart_logistics.smart_logistics.observer.LowStockAlert;
import com.maven_smart_logistics.smart_logistics.model.Purchase;
import com.maven_smart_logistics.smart_logistics.model.Product;
import com.maven_smart_logistics.smart_logistics.model.Stock;

@Service
public class InventoryService {
    @Autowired
    private StockRepository stockRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    private LowStockAlert lowStockAlert = new LowStockAlert();
    
    public void processPurchase(Purchase purchase) {
        // Obtener productos del almacén
        List<Product> products = productRepository.findByWarehouseId(purchase.getWarehouse().getId());
        
        // Actualizar stock
        products.forEach(product -> {
            Stock stock = stockRepository.findByProductId(product.getId())
                                      .orElseThrow(() -> new RuntimeException("Stock no encontrado"));
            stock.decreaseStock(purchase.getQuantity());
            stock.addObserver(lowStockAlert);
            stockRepository.save(stock);
        });
    }
}
