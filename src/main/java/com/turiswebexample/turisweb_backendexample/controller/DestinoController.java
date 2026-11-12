package com.turiswebexample.turisweb_backendexample.controller;

import com.turiswebexample.turisweb_backendexample.model.Destino;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/destinos")
public class DestinoController {

    private final List<Destino> destinos = new ArrayList<>(List.of(
        new Destino(1L, "Comuna 13", "Medellín"),
        new Destino(2L, "Monserrate", "Bogotá")
    ));

    private long siguienteId = 3L;

    @GetMapping
    public List<Destino> listarDestinos() {

        return destinos;
    }

    @PostMapping
    public ResponseEntity<Destino> crearDestino(
            @RequestBody Destino nuevoDestino) {

        nuevoDestino.setId(siguienteId++);

        destinos.add(nuevoDestino);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoDestino);
    }


@PutMapping("/{id}")
public ResponseEntity<Destino> actualizarDestino(
        @PathVariable Long id,
        @RequestBody Destino datosActualizados) {

    // Buscar el destino por su identificador
    Destino destinoExistente = buscarDestino(id);

    // Comprobar si existe
    if (destinoExistente == null) {
        return ResponseEntity.notFound().build();
    }

    // Comprobar que recibimos todos los campos necesarios
    if (datosActualizados.getNombre() == null ||
        datosActualizados.getCiudad() == null) {

        return ResponseEntity.badRequest().build();
    }

    // Actualizar la información
    destinoExistente.setNombre(datosActualizados.getNombre());
    destinoExistente.setCiudad(datosActualizados.getCiudad());

    // Devolver el destino actualizado
    return ResponseEntity.ok(destinoExistente);
}

    private Destino buscarDestino(Long id) {
        for (Destino destino : destinos) {
            if (destino.getId() != null && destino.getId().equals(id)) {
                return destino;
            }
        }
        return null;
    }

}
