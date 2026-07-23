package org.cat.biblioteca_clean_architecture.infrastructure.adapters.output;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<LibroEntity, Long> {

    /**
     * Spring Data JPA traduce esto a una consulta que hace JOIN con la
     * tabla intermedia libro_autor y filtra por autor_id, sin necesidad
     * de escribir JPQL a mano. "Autores_Id" navega la colección
     * autores -> id.
     */
    List<LibroEntity> findByAutores_Id(Long autorId);

    /**
     * Misma navegación, pero agregando el filtro opcional de año.
     */
    List<LibroEntity> findByAutores_IdAndAnioPublicacion(Long autorId, Integer anioPublicacion);
}
