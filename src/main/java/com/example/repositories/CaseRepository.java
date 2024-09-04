package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.CaseEntity;

@Repository
public interface CaseRepository extends JpaRepository<CaseEntity, String> {
    
}
