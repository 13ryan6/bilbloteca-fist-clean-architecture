package org.cat.biblioteca_clean_architecture.application.ports.input;

import org.cat.biblioteca_clean_architecture.domain.model.Libro;

import java.util.List;

public interface ILibroUseCase {

    Libro create(Libro libro);

    /**
     * Libros de un autor específico, opcionalmente filtrados por año de
     * publicación. Si anio es null, retorna todos los libros de ese autor.
     */
    List<Libro> findByAutorAndAnio(Long autorId, Integer anio);
}