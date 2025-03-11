package com.maven_smart_logistics.smart_logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maven_smart_logistics.smart_logistics.model.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

}
