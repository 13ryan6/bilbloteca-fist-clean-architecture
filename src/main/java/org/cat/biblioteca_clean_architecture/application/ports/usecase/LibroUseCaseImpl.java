package org.cat.biblioteca_clean_architecture.application.ports.usecase;

import org.cat.biblioteca_clean_architecture.application.ports.input.ILibroUseCase;
import org.cat.biblioteca_clean_architecture.application.ports.output.AutorPorts;
import org.cat.biblioteca_clean_architecture.application.ports.output.LibroPorts;
import org.cat.biblioteca_clean_architecture.domain.model.Autor;
import org.cat.biblioteca_clean_architecture.domain.model.Libro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroUseCaseImpl implements ILibroUseCase {

    private final LibroPorts libroPorts;
    private final AutorPorts autorPorts;

    public LibroUseCaseImpl(LibroPorts libroPorts, AutorPorts autorPorts) {
        this.libroPorts = libroPorts;
        this.autorPorts = autorPorts;
    }

    @Override
    public Libro create(Libro libro) {
        List<Long> idsRecibidos = libro.getAutores().stream()
                .map(Autor::getId)
                .toList();

        List<Autor> autoresExistentes = autorPorts.findAllByIds(idsRecibidos);

        if (autoresExistentes.size() != idsRecibidos.size()) {
            throw new IllegalArgumentException(
                    "Uno o más autores no existen. Verifica los IDs enviados.");
        }

        libro.setAutores(autoresExistentes);
        return libroPorts.create(libro);
    }

    @Override
    public List<Libro> findByAutorAndAnio(Long autorId, Integer anio) {
        autorPorts.findById(autorId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe un autor con id " + autorId));

        return libroPorts.findByAutorAndAnio(autorId, anio);
    }
}
