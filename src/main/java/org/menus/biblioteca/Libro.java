package org.menus.biblioteca;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @Size(max = 20)
    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;

    @Size(max = 200)
    @NotNull
    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Size(max = 100)
    @NotNull
    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    @OneToMany(mappedBy = "isbn")
    private Set<Ejemplar> ejemplars = new LinkedHashSet<>();

    public @Size(max = 20) String getIsbn() {
        return isbn;
    }

    public void setIsbn(@Size(max = 20) String isbn) {
        this.isbn = isbn;
    }

    public @Size(max = 200) @NotNull String getTitulo() {
        return titulo;
    }

    public void setTitulo(@Size(max = 200) @NotNull String titulo) {
        this.titulo = titulo;
    }

    public @Size(max = 100) @NotNull String getAutor() {
        return autor;
    }

    public void setAutor(@Size(max = 100) @NotNull String autor) {
        this.autor = autor;
    }

    public Set<Ejemplar> getEjemplars() {
        return ejemplars;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ejemplars=" + ejemplars +
                '}';
    }

    public void setEjemplars(Set<Ejemplar> ejemplars) {
        this.ejemplars = ejemplars;


    }
}