package com.ronan.talestore.service;

import java.util.List;
import java.util.Optional;

import com.ronan.talestore.DTO.CategoriaDTO;
import com.ronan.talestore.domain.Categoria;
import com.ronan.talestore.repository.CategoriaRepository;
import com.ronan.talestore.service.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;
    
    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria create(Categoria obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Integer id, CategoriaDTO objDto) {
        Categoria obj = findById(id);
        obj.setNome(objDto.getNome());
        obj.setDescricao(objDto.getDescricao());
        return repository.save(obj);
    }
}
