package com.maven_smart_logistics.smart_logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.maven_smart_logistics.smart_logistics.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByWarehouseId(Long warehouseId);
}
