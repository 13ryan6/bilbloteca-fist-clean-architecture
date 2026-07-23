package org.cat.biblioteca_clean_architecture.infrastructure.adapters.input;

import jakarta.validation.Valid;
import org.cat.biblioteca_clean_architecture.application.ports.input.IAutorUseCase;
import org.cat.biblioteca_clean_architecture.domain.model.Autor;
import org.cat.biblioteca_clean_architecture.infrastructure.adapters.input.dto.AutorRequest;
import org.cat.biblioteca_clean_architecture.infrastructure.adapters.input.dto.AutorResponse;
import org.cat.biblioteca_clean_architecture.infrastructure.adapters.input.mapper.AutorRequestMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/autores")
public class AutorController {

    private final IAutorUseCase autorUseCase;
    private final AutorRequestMapper autorRequestMapper;

    public AutorController(IAutorUseCase autorUseCase, AutorRequestMapper autorRequestMapper) {
        this.autorUseCase = autorUseCase;
        this.autorRequestMapper = autorRequestMapper;
    }

    @PostMapping
    public ResponseEntity<AutorResponse> create(@Valid @RequestBody AutorRequest request) {
        Autor autor = autorRequestMapper.toAutor(request);
        Autor creado = autorUseCase.create(autor);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(autorRequestMapper.toAutorResponse(creado));
    }
}