package org.cat.biblioteca_clean_architecture.domain.model;

import java.util.List;

/**
 * Libro SÍ conoce a sus Autores (List<Autor> autores), porque el lado
 * "muchos libros - muchos autores" necesita saber quiénes lo escribieron
 * (al crear un libro, seleccionas autores existentes por id). Como Autor
 * no tiene de vuelta una lista de libros, no hay recursividad al mapear.
 */
public class Libro {

    private Long id;
    private String titulo;
    private String isbn;
    private Integer anioPublicacion;
    private List<Autor> autores;

    public Libro() {
    }

    public Libro(Long id, String titulo, String isbn, Integer anioPublicacion, List<Autor> autores) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.autores = autores;
    }

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

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                '}';
    }
}
