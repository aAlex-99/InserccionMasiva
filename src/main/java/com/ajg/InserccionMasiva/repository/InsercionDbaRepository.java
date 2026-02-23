package com.ajg.InserccionMasiva.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ajg.InserccionMasiva.models.Persona;

@Repository
public class InsercionDbaRepository {

    private final SimpleJdbcCall jdbcCall;

    public InsercionDbaRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PA_PERSONAS")
                .withProcedureName("SP_INSERT");
    }

    public Map<String,Object> insertar(Persona persona){

        Map<String,Object> in = new HashMap<>();

        in.put("PA_APELLIDOPATERNO", persona.getApellidoPaterno());
        in.put("PA_APELLIDOMATERNO", persona.getApellidoMaterno());
        in.put("PA_NOMBRES", persona.getNombres());
        in.put("PA_FECHANACIMIENTO", persona.getFechaNacimiento());
        in.put("PA_RFC", persona.getRfc());
        in.put("PA_DIRECCION", persona.getDireccion());
        in.put("PA_COLONIAPOBLACION", persona.getColonia());
        in.put("PA_DELEGACIONMUNICIPIO", persona.getMunicipio());
        in.put("PA_CIUDAD", persona.getCiudad());
        in.put("PA_ESTADO", persona.getEstado());
        in.put("PA_CP", persona.getCp());
        in.put("PA_FDREGISTRO", new Date());
        in.put("PA_USUARIO_MODIFICO", "SYSTEM");

        return jdbcCall.execute(in);
    }
}
