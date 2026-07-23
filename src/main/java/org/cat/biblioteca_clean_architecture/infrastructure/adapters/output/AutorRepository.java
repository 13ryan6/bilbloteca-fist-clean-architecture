package org.cat.biblioteca_clean_architecture.infrastructure.adapters.output;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<AutorEntity, Long> {
}
