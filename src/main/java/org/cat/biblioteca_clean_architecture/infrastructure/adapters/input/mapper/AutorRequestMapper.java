package org.cat.biblioteca_clean_architecture.infrastructure.adapters.input.mapper;
import org.cat.biblioteca_clean_architecture.domain.model.Autor;
import org.cat.biblioteca_clean_architecture.infrastructure.adapters.input.dto.AutorRequest;
import org.cat.biblioteca_clean_architecture.infrastructure.adapters.input.dto.AutorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AutorRequestMapper {

    AutorRequestMapper INSTANCE = Mappers.getMapper(AutorRequestMapper.class);

    Autor toAutor(AutorRequest request);

    AutorResponse toAutorResponse(Autor autor);
}