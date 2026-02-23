package com.ajg.InserccionMasiva.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "bdsql")
public class Properties {

    private String ip;
    private int puerto;
    private String nombrebdsql;
    private String usrbdsql;
    private String pwbdsql;

}

