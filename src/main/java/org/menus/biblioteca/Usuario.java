package org.menus.biblioteca;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 15)
    @NotNull
    @Column(name = "dni", nullable = false, length = 15)
    @Pattern(regexp = "^[0-9]{8}[A-Za-z]$")

    private String dni;

    @Size(max = 100)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 100)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$")

    private String nombre;

    @Size(max = 100)
    @NotNull
    @Column(name = "email", nullable = false, length = 100)
    @Pattern(regexp = "[A-Za-z0-9]{1,50}@gmail.com")

    private String email;

    @Size(max = 255)
    @NotNull
    @Column(name = "password", nullable = false)
    @Pattern(regexp = "[A-Za-z0-9]{4,12}")

    private String password;

    @NotNull
    @Lob
    @Column(name = "tipo", nullable = false)
    @Pattern(regexp = "^(normal|administrador)$")

    private String tipo;

    @Column(name = "penalizacionhasta")
    private LocalDate penalizacionhasta;

    private boolean isValidDNI(String dni) {
        if (dni == null || dni.length() != 9) {
            return false; // El DNI debe tener exactamente 9 caracteres
        }

        String numeros = dni.substring(0, 8);
        char letra = dni.charAt(8);
        int numero;

        try {
            numero = Integer.parseInt(numeros);
        } catch (NumberFormatException e) {
            return false; // Los primeros 8 caracteres deben ser dígitos
        }

        String[] letras = new String[]{"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        int resultado = numero % 23;

        // Verificar que la letra coincide con la calculada
        return String.valueOf(letra).equals(letras[resultado]);
    }

    @OneToMany(mappedBy = "usuario")
    private Set<Prestamo> prestamos = new LinkedHashSet<>();

    public Usuario() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @Size(max = 15) @NotNull String getDni() {
        return dni;
    }

    public void setDni(@Size(max = 15) @NotNull String dni) {
        this.dni = dni;
    }

    public @Size(max = 100) @NotNull String getNombre() {
        return nombre;
    }

    public void setNombre(@Size(max = 100) @NotNull String nombre) {
        this.nombre = nombre;
    }

    public @Size(max = 100) @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@Size(max = 100) @NotNull String email) {
        this.email = email;
    }

    public @Size(max = 255) @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@Size(max = 255) @NotNull String password) {
        this.password = password;
    }

    public @NotNull String getTipo() {
        return tipo;
    }

    public void setTipo(@NotNull String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getPenalizacionhasta() {
        return penalizacionhasta;
    }

    public void setPenalizacionhasta(LocalDate penalizacionhasta) {
        this.penalizacionhasta = penalizacionhasta;
    }

    public Set<Prestamo> getPrestamos() {
        return prestamos;
    }
    @JsonManagedReference
    public void setPrestamos(Set<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }


}