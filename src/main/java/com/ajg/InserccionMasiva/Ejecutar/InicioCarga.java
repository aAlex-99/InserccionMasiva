package com.ajg.InserccionMasiva.Ejecutar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ajg.InserccionMasiva.service.CsvService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InicioCarga implements CommandLineRunner {

    private final CsvService service;

    @Override
    public void run(String... args) throws Exception {

        service.cargar();

        System.out.println("CARGA FINALIZADA");

    }

}

