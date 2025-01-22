package Dto;

import org.menus.biblioteca.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@author AlejandroGpublic

public interface LibroRepo extends JpaRepository<Libro, Integer> {
    List<Libro> findById(String isbn);
}
