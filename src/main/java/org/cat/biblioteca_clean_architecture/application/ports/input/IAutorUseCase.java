package org.cat.biblioteca_clean_architecture.application.ports.input;

import org.cat.biblioteca_clean_architecture.domain.model.Autor;

public interface IAutorUseCase {

    Autor create(Autor autor);

    Autor findById(Long id);
}
