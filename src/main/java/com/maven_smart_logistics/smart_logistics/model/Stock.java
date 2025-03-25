package com.maven_smart_logistics.smart_logistics.model;
import com.maven_smart_logistics.smart_logistics.observer.StockObserver;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int quantity;
    
    @OneToOne
    private Product product;
    
    private transient List<StockObserver> observers = new ArrayList<>();
    
    // Métodos del Observer
    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }
    
    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }
    
    public void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(this);
        }
    }
    
    // Métodos de negocio
    public void decreaseStock(int amount) {
        this.quantity -= amount;
        notifyObservers();
    }
    
    public void increaseStock(int amount) {
        this.quantity += amount;
        notifyObservers();
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<StockObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<StockObserver> observers) {
        this.observers = observers;
    }

}
