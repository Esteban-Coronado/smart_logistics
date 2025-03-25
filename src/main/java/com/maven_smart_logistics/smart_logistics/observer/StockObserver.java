package com.maven_smart_logistics.smart_logistics.observer;

import com.maven_smart_logistics.smart_logistics.model.Stock;

public interface StockObserver {
    void update(Stock stock);
}
