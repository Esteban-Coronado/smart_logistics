package com.maven_smart_logistics.smart_logistics.observer;

import com.maven_smart_logistics.smart_logistics.model.Stock;

public class LowStockAlert implements StockObserver {
    private static final int LOW_STOCK_THRESHOLD = 10;
    
    @Override
    public void update(Stock stock) {
        if (stock.getQuantity() < LOW_STOCK_THRESHOLD) {
            System.out.println("ALERTA: Stock bajo para producto " + 
                stock.getProduct().getName() + 
                ". Cantidad actual: " + stock.getQuantity());
        }
    }
}
