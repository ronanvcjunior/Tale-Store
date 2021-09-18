package com.ronan.talestore.DTO;

import java.io.Serializable;

import com.ronan.talestore.domain.Conto;

public class ContoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String titulo;

    public ContoDTO() {
    }

    public ContoDTO(Conto obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ContoDTO id(Integer id) {
        setId(id);
        return this;
    }

    public ContoDTO titulo(String titulo) {
        setTitulo(titulo);
        return this;
    }
}
