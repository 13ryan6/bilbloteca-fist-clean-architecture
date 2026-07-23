package org.cat.biblioteca_clean_architecture.application.ports.output;

import org.cat.biblioteca_clean_architecture.domain.model.Autor;

import java.util.List;
import java.util.Optional;

public interface AutorPorts {

    Autor create(Autor autor);

    Optional<Autor> findById(Long id);

    /**
     * Usado por LibroUseCaseImpl para resolver y validar los IDs de
     * autores recibidos al crear un libro.
     */
    List<Autor> findAllByIds(List<Long> ids);
}