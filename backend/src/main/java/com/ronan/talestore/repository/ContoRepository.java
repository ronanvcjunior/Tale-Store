package com.ronan.talestore.repository;

import java.util.List;

import com.ronan.talestore.domain.Conto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContoRepository extends JpaRepository<Conto, Integer> {

    @Query("SELECT obj FROM Conto obj WHERE obj.categoria.id = :id_categoria ORDER BY titulo")
    List<Conto> findAllByCategoria(@Param(value = "id_categoria") Integer id_categoria);
    
}
