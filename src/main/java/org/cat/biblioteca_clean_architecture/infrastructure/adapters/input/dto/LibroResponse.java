package org.cat.biblioteca_clean_architecture.infrastructure.adapters.input.dto;

import java.util.List;

public class LibroResponse {

    private Long id;
    private String titulo;
    private String isbn;
    private Integer anioPublicacion;
    private List<AutorResponse> autores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public List<AutorResponse> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorResponse> autores) {
        this.autores = autores;
    }
}
