package com.maven_smart_logistics.smart_logistics.repository;


import com.maven_smart_logistics.smart_logistics.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
