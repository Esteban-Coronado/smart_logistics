package com.maven_smart_logistics.smart_logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.maven_smart_logistics.smart_logistics.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByProductId(Long productId);
}
