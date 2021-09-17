package com.ronan.talestore.repository;

import com.ronan.talestore.domain.Conto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContoRepository extends JpaRepository<Conto, Integer> {
    
}
