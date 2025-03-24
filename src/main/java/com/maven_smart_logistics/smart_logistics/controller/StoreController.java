package com.maven_smart_logistics.smart_logistics.controller;

import com.maven_smart_logistics.smart_logistics.model.Store;
import com.maven_smart_logistics.smart_logistics.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @PostMapping
    public Store saveStore(@RequestBody Store store) {
        return storeService.saveStore(store);
    }

    @GetMapping("/{id}")
    public Store getStoreById(Long id) {
        return storeService.getStoreById(id);
    }
}
