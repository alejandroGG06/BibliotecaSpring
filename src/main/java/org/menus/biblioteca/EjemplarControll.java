package org.menus.biblioteca;

//@author AlejandroGpublic

import jakarta.persistence.Cacheable;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/ejemplares")

class EjemplarControll {
    ejemplarRepo repo;
    LibroRepo librosRepositorio;


    public EjemplarControll() {}


        @Autowired
        public EjemplarControll(ejemplarRepo repo, LibroRepo repositorio2) {
            this.repo = repo;
            this.librosRepositorio = repositorio2;
        }


        //SELECT *
        @GetMapping
        public ResponseEntity<List<Ejemplar>> getEjemplares() {
            List<Ejemplar> lista = this.repo.findAll();
            System.out.println(lista);
            return ResponseEntity.ok(lista);
        }

        //SELECT BY ISBN
        @GetMapping("/{id}")

        public ResponseEntity<Ejemplar> getEjemplarJson(@PathVariable String id){
            Ejemplar e = this.repo.findById(id).get();
            return ResponseEntity.ok(e);
        }

        //INSERT
        @PostMapping("/ejemplar")
        public ResponseEntity<Ejemplar> addEjemplar(@Valid @RequestBody Ejemplar ejemplar) {
            Ejemplar ejemplarPersistido = this.repo.save(ejemplar);
            return ResponseEntity.ok().body(ejemplarPersistido);
        }

        // POST con Form normal
        @PostMapping(value = "/ejemplarForm", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public ResponseEntity<Ejemplar> addEjemplarForm(
                @RequestParam Integer id,
                @RequestParam String estado,
                @RequestParam String isbn
        ) {
            Ejemplar ejemplar = new Ejemplar();
            ejemplar.setId(id);
            ejemplar.setEstado(estado);

            Libro libro =librosRepositorio.findById(isbn).orElse(null);

            ejemplar.setIsbn(libro);

            Ejemplar ejemplarPersistido = this.repo.save(ejemplar);
            return ResponseEntity.created(null).body(ejemplarPersistido);
        }

        //UPDATE
        @PutMapping("/{id}")
        public ResponseEntity<Ejemplar> updateEjemplar(@RequestBody Ejemplar ejemplar, @PathVariable String id){
            Ejemplar ejemplarPersistido = repo.save(ejemplar);
            return ResponseEntity.ok().body(ejemplarPersistido);
        }

        //DELETE
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteEjemplar(@PathVariable String id){
            repo.deleteById(id);
            String mensaje = "ejemplar con id: "+id+" borrado";
            return ResponseEntity.ok().body(mensaje);
        }
}
