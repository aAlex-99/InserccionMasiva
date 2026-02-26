package com.ajg.InserccionMasiva.Ejecutar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ajg.InserccionMasiva.service.CsvService;
import com.ajg.InserccionMasiva.utils.Log;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InicioCarga implements CommandLineRunner {

    private final CsvService service;

    @Override
    public void run(String... args) throws Exception {
    	long inicio = System.currentTimeMillis();
        service.cargar();
        
        Log.info("INICIANDO PROCESO BATCH");

        long fin = System.currentTimeMillis();
        Log.info("PROCESO FINALIZADO");
        Log.info("Tiempo total: "
                + (fin - inicio) + " ms");

    }

}

