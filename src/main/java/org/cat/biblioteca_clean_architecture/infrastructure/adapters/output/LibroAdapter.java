package org.cat.biblioteca_clean_architecture.infrastructure.adapters.output;

import org.cat.biblioteca_clean_architecture.application.ports.output.LibroPorts;
import org.cat.biblioteca_clean_architecture.domain.model.Libro;
import org.cat.biblioteca_clean_architecture.infrastructure.adapters.output.mapper.LibroEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibroAdapter implements LibroPorts {

    private final LibroRepository libroRepository;
    private final LibroEntityMapper libroEntityMapper;

    public LibroAdapter(LibroRepository libroRepository, LibroEntityMapper libroEntityMapper) {
        this.libroRepository = libroRepository;
        this.libroEntityMapper = libroEntityMapper;
    }

    @Override
    public Libro create(Libro libro) {
        LibroEntity entity = libroEntityMapper.toEntity(libro);
        LibroEntity guardado = libroRepository.save(entity);
        return libroEntityMapper.toLibro(guardado);
    }

    @Override
    public List<Libro> findByAutorAndAnio(Long autorId, Integer anio) {
        List<LibroEntity> entidades = (anio == null)
                ? libroRepository.findByAutores_Id(autorId)
                : libroRepository.findByAutores_IdAndAnioPublicacion(autorId, anio);

        return entidades.stream()
                .map(libroEntityMapper::toLibro)
                .toList();
    }
}
