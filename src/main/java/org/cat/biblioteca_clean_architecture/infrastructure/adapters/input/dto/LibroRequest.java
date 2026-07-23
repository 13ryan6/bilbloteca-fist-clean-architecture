package org.cat.biblioteca_clean_architecture.infrastructure.adapters.input.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class LibroRequest {

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    private String isbn;

    @NotNull(message = "El año de publicación es obligatorio")
    private Integer anioPublicacion;

    @NotEmpty(message = "Debe indicar al menos un autor")
    private List<Long> autorIds;

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

    public List<Long> getAutorIds() {
        return autorIds;
    }

    public void setAutorIds(List<Long> autorIds) {
        this.autorIds = autorIds;
    }
}
