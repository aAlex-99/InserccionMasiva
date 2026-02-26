package com.ajg.InserccionMasiva.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ajg.InserccionMasiva.constants.RutasArchivo;
import com.ajg.InserccionMasiva.models.Persona;
import com.ajg.InserccionMasiva.repository.InsercionDbaRepository;
import com.ajg.InserccionMasiva.utils.Log;

@Service
public class CsvService {

    private final InsercionDbaRepository repository;

    public CsvService(InsercionDbaRepository repository) {
        this.repository = repository;
    }

    public void cargar() throws Exception {

        File archivo = new File(RutasArchivo.RUTA_ENTRADA);

        if (!archivo.exists()) {
            throw new Exception("Archivo no encontrado: "
                    + archivo.getAbsolutePath());
        }

        Log.info("Iniciando lectura: " + archivo.getAbsolutePath());

        Map<String, Persona> mapa = new HashMap<>(1_000_000);

        try (BufferedReader br =
                     new BufferedReader(new FileReader(archivo), 65536)) {

            String linea;

            br.readLine();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            while ((linea = br.readLine()) != null) {

                String[] d = linea.split(",");

                if (d.length < 12) {
                    Log.info("Línea inválida: " + linea);
                    continue;
                }

                Persona p = new Persona();

                p.setApellidoPaterno(d[0]);
                p.setApellidoMaterno(d[1]);
                p.setNombres(d[2]);
                p.setFechaNacimiento(sdf.parse(d[3]));
                p.setRfc(d[4]);
                p.setDireccion(d[5]);
                p.setColonia(d[6]);
                p.setMunicipio(d[7]);
                p.setCiudad(d[8]);
                p.setEstado(d[9]);
                p.setCp(d[10]);
                p.setUsuario(d[11]);

                repository.insertar(p);
            }
        }
    }
}
