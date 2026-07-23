package org.cat.biblioteca_clean_architecture.domain.model;

/**
 * Modelo de dominio puro. Sin anotaciones de JPA ni de Spring.
 *
 * IMPORTANTE: Autor NO tiene una lista de libros (List<Libro> libros).
 * Es intencional: evita un ciclo infinito al mapear (Autor -> Libro ->
 * Autor -> Libro...) y evita que el dominio de Autor dependa del de Libro.
 * "Los libros de un autor" se resuelve como una consulta desde el lado
 * de Libro (lo verás en el Paso de los Ports), no como una colección
 * cargada en memoria dentro de Autor.
 */
public class Autor {

    private Long id;
    private String nombres;
    private String apellidos;
    private String nacionalidad;

    public Autor() {
    }

    public Autor(Long id, String nombres, String apellidos, String nacionalidad) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}
