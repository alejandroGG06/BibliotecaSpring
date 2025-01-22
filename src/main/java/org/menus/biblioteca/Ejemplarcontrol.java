package org.menus.biblioteca;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ejemplar")
public class Ejemplarcontrol {

    EjemplarRepo ejemplarRepo;
    public Ejemplarcontrol() {}
@Autowired
public Ejemplarcontrol(EjemplarRepo ejemplarRepo) {
        this.ejemplarRepo = ejemplarRepo;
}
@GetMapping()
    public ResponseEntity<List<Ejemplar>>getemplars() {
        List<Ejemplar> ejemplars = ejemplarRepo.findAll();
    System.out.println(ejemplars);
    return ResponseEntity.ok(ejemplars);
}

}
