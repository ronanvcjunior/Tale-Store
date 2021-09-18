package com.ronan.talestore.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.ronan.talestore.DTO.ContoDTO;
import com.ronan.talestore.domain.Conto;
import com.ronan.talestore.service.ContoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/contos")
public class ContoController {

    @Autowired
    private ContoService service;

    @GetMapping
    public ResponseEntity<List<ContoDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_categoria) {
        List<Conto> list = service.findAll(id_categoria);
        List<ContoDTO> listDTO = list.stream().map(obj -> new ContoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Conto> findById(@PathVariable Integer id) {
        Conto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Conto> create(@RequestParam(value = "categoria", defaultValue = "0") Integer id_categoria, @RequestBody Conto obj) {
        obj = service.create(id_categoria, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/contos/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Conto> update(@PathVariable Integer id, @RequestBody Conto obj) {
        Conto newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Conto> updatePatch(@PathVariable Integer id, @RequestBody Conto obj) {
        Conto newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
