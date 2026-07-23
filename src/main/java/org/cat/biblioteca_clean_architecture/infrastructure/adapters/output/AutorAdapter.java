package org.cat.biblioteca_clean_architecture.infrastructure.adapters.output;

import org.cat.biblioteca_clean_architecture.application.ports.output.AutorPorts;
import org.cat.biblioteca_clean_architecture.domain.model.Autor;
import org.cat.biblioteca_clean_architecture.infrastructure.adapters.output.mapper.AutorEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AutorAdapter implements AutorPorts {

    private final AutorRepository autorRepository;
    private final AutorEntityMapper autorEntityMapper;

    public AutorAdapter(AutorRepository autorRepository, AutorEntityMapper autorEntityMapper) {
        this.autorRepository = autorRepository;
        this.autorEntityMapper = autorEntityMapper;
    }

    @Override
    public Autor create(Autor autor) {
        AutorEntity entity = autorEntityMapper.toEntity(autor);
        AutorEntity guardado = autorRepository.save(entity);
        return autorEntityMapper.toAutor(guardado);
    }

    @Override
    public Optional<Autor> findById(Long id) {
        return autorRepository.findById(id)
                .map(autorEntityMapper::toAutor);
    }

    @Override
    public List<Autor> findAllByIds(List<Long> ids) {
        return autorRepository.findAllById(ids).stream()
                .map(autorEntityMapper::toAutor)
                .toList();
    }
}