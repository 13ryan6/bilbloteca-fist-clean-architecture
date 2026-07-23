package org.cat.biblioteca_clean_architecture.infrastructure.adapters.input.mapper;
import org.cat.biblioteca_clean_architecture.domain.model.Autor;
import org.cat.biblioteca_clean_architecture.domain.model.Libro;
import org.cat.biblioteca_clean_architecture.infrastructure.adapters.input.dto.LibroRequest;
import org.cat.biblioteca_clean_architecture.infrastructure.adapters.input.dto.LibroResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface LibroRequestMapper {

    LibroRequestMapper INSTANCE = Mappers.getMapper(LibroRequestMapper.class);

    @Mapping(target = "autores", ignore = true)
    Libro toLibro(LibroRequest request);

    LibroResponse toLibroResponse(Libro libro);

    default List<Autor> mapAutorIds(List<Long> autorIds) {
        return autorIds.stream()
                .map(id -> {
                    Autor autor = new Autor();
                    autor.setId(id);
                    return autor;
                })
                .collect(Collectors.toList());
    }
}
