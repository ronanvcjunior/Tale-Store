package com.ronan.talestore.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Conto implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    @Column(name = "nome_autor")
    private String nomeAutor;

    private String texto;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Conto() {

    }

    public Conto(Integer id, String titulo, String nomeAutor, String texto, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.nomeAutor = nomeAutor;
        this.texto = texto;
        this.categoria = categoria;
    }

    public Conto(String titulo, String nomeAutor, String texto, Categoria categoria) {
        this.titulo = titulo;
        this.nomeAutor = nomeAutor;
        this.texto = texto;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conto other = (Conto) obj;
		return Objects.equals(id, other.id);
	}
}
