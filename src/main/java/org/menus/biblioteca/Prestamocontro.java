package org.menus.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("/addpres")
    public ResponseEntity<Prestamo> addprestamo(@RequestBody Prestamo prestamo) {
        this.prestamoRepo.save(prestamo);
        return ResponseEntity.created(null).body(prestamo);
    }


}
