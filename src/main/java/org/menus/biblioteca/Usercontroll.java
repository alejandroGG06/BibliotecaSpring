package org.menus.biblioteca;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


//@author AlejandroGpublic
@RestController
@RequestMapping("/users")
public class Usercontroll {
    usuarioRepo usuarioRepo;

    public Usercontroll(){
    }

    @Autowired
    public Usercontroll(usuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>>getUsers(){
        List<Usuario> usuarios = usuarioRepo.findAll();
        System.out.println(usuarios);
        return ResponseEntity.ok(usuarios);
    }


//    @PostMapping(value = "/usuarioForm", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Usuario>addUsuario(     @RequestParam Integer id,
//                                                  @RequestParam String dni,
//                                                  @RequestParam String nombre,
//                                                  @RequestParam String email,
//                                                  @RequestParam String password,
//                                                  @RequestParam String tipo,
//                                                  @RequestParam LocalDate penalizacion){
//        Usuario usuario = new Usuario();
//        usuario.setId(id);
//        usuario.setDni(dni);
//        usuario.setNombre(nombre);
//        usuario.setEmail(email);
//        usuario.setPassword(password);
//        usuario.setTipo(tipo);
//        usuario.setPenalizacionhasta(penalizacion);
//
//
//        this.usuarioRepo.save(usuario);
//        return ResponseEntity.created(null).body(usuario);
//    }

    @PostMapping(value = "/usuarioForm2", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario>addUsuario( @RequestBody Usuario usuario  ) {

        this.usuarioRepo.save(usuario);
        return ResponseEntity.created(null).body(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        Usuario user= usuarioRepo.save(usuario);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deluser(@PathVariable int id) {
        usuarioRepo.deleteById(id);
        String mensaje = "Usuario eliminado con exito";
        return ResponseEntity.ok().body(mensaje);
    }




}
