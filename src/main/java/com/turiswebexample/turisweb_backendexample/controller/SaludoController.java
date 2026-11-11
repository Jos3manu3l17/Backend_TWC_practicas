package com.turiswebexample.turisweb_backendexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class SaludoController {

    @GetMapping("/saludo")
    public Map<String, String> obtenerSaludo() {

        return Map.of(
            "mensaje", "Bienvenido a TurisWeb Colombia",
            "estado", "Backend funcionando correctamente",
            "tecnologia", "Spring Boot",
            "Nombre del proyecto", "TurisWeb Colombia",
            "version", "1.0.0",
            "Pais", "Colombia"
        );
    }
}
