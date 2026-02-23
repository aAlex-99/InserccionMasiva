package com.ajg.InserccionMasiva.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/**
 * Corre clase configuracion
 *
 * @author Alejandro-Jimenez
 */
@Component
@NoArgsConstructor
@Slf4j
public class AppSetup {

    @Value("${ajg.info.app.java.version}")
	private String appJavaVersion;
	@Value("${ajg.info.app.name}")
	private String appName;
	@Value("${ajg.info.app.version}")
	private String appVersion;


    /**
     * metodo de carga de configuracion inicial
     */
    @PostConstruct
    public void init() {
        /*
         * Escribir
         * en log
         * nombre
         * de
         * la
         * aplicacion
         * y
         * version
         **/

        // Nombre y version de la aplicación
        String application = appName + " " + appVersion;

        // Loggear la información
        log.info("****************** Configurando ".concat(application).concat(" ******************"));
    }
}
