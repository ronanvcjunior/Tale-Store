package com.ronan.talestore.DTO;

import java.io.Serializable;

import com.ronan.talestore.domain.Categoria;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String descricao;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaDTO id(Integer id) {
        setId(id);
        return this;
    }

    public CategoriaDTO nome(String nome) {
        setNome(nome);
        return this;
    }

    public CategoriaDTO descricao(String descricao) {
        setDescricao(descricao);
        return this;
    }
}
