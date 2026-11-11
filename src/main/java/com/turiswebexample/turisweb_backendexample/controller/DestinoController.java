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
}
