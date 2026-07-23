package org.cat.biblioteca_clean_architecture.application.ports.output;

import org.cat.biblioteca_clean_architecture.domain.model.Libro;

import java.util.List;

public interface LibroPorts {

    Libro create(Libro libro);

    List<Libro> findByAutorAndAnio(Long autorId, Integer anio);
}