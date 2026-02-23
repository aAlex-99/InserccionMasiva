package com.ajg.InserccionMasiva.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

import com.ajg.InserccionMasiva.models.Persona;
import com.ajg.InserccionMasiva.repository.InsercionDbaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CsvService {

    private final InsercionDbaRepository repository;

    public void cargar() throws Exception {

        BufferedReader br = new BufferedReader(
                new FileReader("fileCargar/personas.csv"));

        String line;

        br.readLine();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        while ((line = br.readLine()) != null) {

            String[] d = line.split(",");

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

        br.close();

    }

}
