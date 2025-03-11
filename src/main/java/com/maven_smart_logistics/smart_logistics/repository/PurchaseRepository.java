package com.maven_smart_logistics.smart_logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maven_smart_logistics.smart_logistics.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
