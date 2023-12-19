package com.example.clinica.repository;

import com.example.clinica.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <RoleEntity, Long> {
    
}
