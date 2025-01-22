package org.menus.biblioteca;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@PostMapping(value = "/addejem",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ejemplar>addprestamo( @RequestBody Ejemplar ejemplar  ) {
        this.ejemplarRepo.save(ejemplar);
    return ResponseEntity.ok().body(ejemplar);
}
@PutMapping("/{id}")
public ResponseEntity<Ejemplar>addprestamo(@PathVariable int id ,@RequestBody Ejemplar ejemplar  ) {
 Ejemplar ejemplar1 = this.ejemplarRepo.save(ejemplar);
    return ResponseEntity.ok().body(ejemplar1);
}
@DeleteMapping("/{id}")
    public ResponseEntity<String>deleteprestamo(@PathVariable int id) {
    this.ejemplarRepo.deleteById(id);
    String mensaje="Ejemplar eliminado";
    return ResponseEntity.ok().body(mensaje);}

}
