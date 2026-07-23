package org.cat.biblioteca_clean_architecture.infrastructure.adapters.input;

import jakarta.validation.Valid;
import org.cat.biblioteca_clean_architecture.application.ports.input.ILibroUseCase;
import org.cat.biblioteca_clean_architecture.domain.model.Libro;
import org.cat.biblioteca_clean_architecture.infrastructure.adapters.input.dto.LibroRequest;
import org.cat.biblioteca_clean_architecture.infrastructure.adapters.input.dto.LibroResponse;
import org.cat.biblioteca_clean_architecture.infrastructure.adapters.input.mapper.LibroRequestMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/libros")
public class LibroController {

    private final ILibroUseCase libroUseCase;
    private final LibroRequestMapper libroRequestMapper;

    public LibroController(ILibroUseCase libroUseCase, LibroRequestMapper libroRequestMapper) {
        this.libroUseCase = libroUseCase;
        this.libroRequestMapper = libroRequestMapper;
    }

    @PostMapping
    public ResponseEntity<LibroResponse> create(@Valid @RequestBody LibroRequest request) {
        Libro libro = libroRequestMapper.toLibro(request);
        libro.setAutores(libroRequestMapper.mapAutorIds(request.getAutorIds()));

        Libro creado = libroUseCase.create(libro);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(libroRequestMapper.toLibroResponse(creado));
    }

    /**
     * GET /v1/libros?autorId=1&anio=2023
     * "anio" es opcional: si no se envía, retorna todos los libros del autor.
     */
    @GetMapping
    public ResponseEntity<List<LibroResponse>> findByAutorAndAnio(
            @RequestParam Long autorId,
            @RequestParam(required = false) Integer anio) {

        List<Libro> libros = libroUseCase.findByAutorAndAnio(autorId, anio);
        List<LibroResponse> response = libros.stream()
                .map(libroRequestMapper::toLibroResponse)
                .toList();

        return ResponseEntity.ok(response);
    }
}