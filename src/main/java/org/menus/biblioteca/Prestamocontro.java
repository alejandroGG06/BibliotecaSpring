package org.menus.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamo")
public class Prestamocontro {

    PrestamoRepo prestamoRepo;
    public Prestamocontro() {}
    @Autowired
    public Prestamocontro(PrestamoRepo prestamoRepo) {
        this.prestamoRepo = prestamoRepo;
    }

    @GetMapping
    public ResponseEntity<List<Prestamo>> getprestamo() {
        List<Prestamo> prestamo = prestamoRepo.findAll();
        System.out.println(prestamo);
        return ResponseEntity.ok(prestamo);
    }
    @PostMapping(value = "/addpres", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Prestamo> addprestamo(@RequestBody Prestamo prestamo) {
        Prestamo prestamo1=this.prestamoRepo.save(prestamo);
        return ResponseEntity.created(null).body(prestamo1);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Prestamo>updatePrestamo(@PathVariable int id, @RequestBody Prestamo prestamo) {
        Prestamo prestamo1=this.prestamoRepo.save(prestamo);
        return ResponseEntity.ok().body(prestamo1);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deluser(@PathVariable int id) {
        prestamoRepo.deleteById(id);
        String mensaje = "Prestamo eliminado con exito";
        return ResponseEntity.ok().body(mensaje);
    }


}
