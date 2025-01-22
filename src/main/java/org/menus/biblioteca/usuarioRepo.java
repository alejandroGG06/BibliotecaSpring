package org.menus.biblioteca;

//@author AlejandroGpublic

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usuarioRepo extends JpaRepository<Usuario,Integer> {

}
