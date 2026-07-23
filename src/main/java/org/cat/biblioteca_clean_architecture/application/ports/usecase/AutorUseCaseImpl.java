package org.cat.biblioteca_clean_architecture.application.ports.usecase;

import org.cat.biblioteca_clean_architecture.application.ports.input.IAutorUseCase;
import org.cat.biblioteca_clean_architecture.application.ports.output.AutorPorts;
import org.cat.biblioteca_clean_architecture.domain.model.Autor;
import org.springframework.stereotype.Service;

@Service
public class AutorUseCaseImpl implements IAutorUseCase {

    private final AutorPorts autorPorts;

    public AutorUseCaseImpl(AutorPorts autorPorts) {
        this.autorPorts = autorPorts;
    }

    @Override
    public Autor create(Autor autor) {
        return autorPorts.create(autor);
    }

    @Override
    public Autor findById(Long id) {
        return autorPorts.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe un autor con id " + id));
    }
}
