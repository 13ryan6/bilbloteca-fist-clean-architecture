package org.cat.biblioteca_clean_architecture.infrastructure.adapters.output.mapper;

import org.cat.biblioteca_clean_architecture.domain.model.Libro;
import org.cat.biblioteca_clean_architecture.infrastructure.adapters.output.LibroEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = AutorEntityMapper.class)
public interface LibroEntityMapper {

    LibroEntityMapper INSTANCE = Mappers.getMapper(LibroEntityMapper.class);

    LibroEntity toEntity(Libro libro);

    Libro toLibro(LibroEntity entity);
}