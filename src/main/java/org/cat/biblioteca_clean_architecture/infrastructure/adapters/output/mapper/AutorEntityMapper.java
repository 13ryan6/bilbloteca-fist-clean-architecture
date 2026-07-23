
package org.cat.biblioteca_clean_architecture.infrastructure.adapters.output.mapper;

import org.cat.biblioteca_clean_architecture.domain.model.Autor;
import org.cat.biblioteca_clean_architecture.infrastructure.adapters.output.AutorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AutorEntityMapper {

    AutorEntityMapper INSTANCE = Mappers.getMapper(AutorEntityMapper.class);

    AutorEntity toEntity(Autor autor);

    Autor toAutor(AutorEntity entity);
}
