package com.ronan.talestore.service;

import java.util.List;
import java.util.Optional;

import com.ronan.talestore.domain.Categoria;
import com.ronan.talestore.domain.Conto;
import com.ronan.talestore.repository.ContoRepository;
import com.ronan.talestore.service.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ContoService {

    @Autowired
    private ContoRepository repository;

    @Autowired
    private CategoriaService categoriaService;

    public List<Conto> findAll(Integer id_categoria) {
        categoriaService.findById(id_categoria);
        return repository.findAllByCategoria(id_categoria);
    }

    public Conto findById(Integer id) {
        Optional<Conto> obj = repository.findById(id);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado! " + id + ", Tipo: " + Conto.class.getName()));
    }

    public Conto create(Integer id_categoria, Conto obj) {
        obj.setId(null);
        Categoria categoria = categoriaService.findById(id_categoria);
        obj.setCategoria(categoria);
        return repository.save(obj);
    }

    public Conto update(Integer id, Conto obj) {
        Conto newObj = findById(id);
        updateDate(newObj, obj);
        return repository.save(newObj);
    }

    private void updateDate(Conto newObj, Conto obj) {
        if (obj.getTitulo() != null) {
            newObj.setTitulo(obj.getTitulo());
        }
        if (obj.getNomeAutor() != null) {
            newObj.setNomeAutor(obj.getNomeAutor());
        }
        if (obj.getTexto() != null) {
            newObj.setTexto(obj.getTexto());
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.ronan.talestore.service.exceptions.DataIntegrityViolationException(
                    "Conto não pode ser deletada! Possui livros associados");
        }
    }
}
