package com.ronan.talestore.service;

import java.util.Optional;

import com.ronan.talestore.domain.Categoria;
import com.ronan.talestore.repository.CategoriaRepository;
import com.ronan.talestore.service.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public Categoria findById(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! " + id + ", Tipo: " + Categoria.class.getName()));
    }
}
