package com.ajg.InserccionMasiva.models;

import java.util.Date;

import lombok.Data;

@Data
public class Persona {

    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private Date fechaNacimiento;
    private String rfc;
    private String direccion;
    private String colonia;
    private String municipio;
    private String ciudad;
    private String estado;
    private String cp;
    private Date fechaRegistro;
    private String usuario;

}

