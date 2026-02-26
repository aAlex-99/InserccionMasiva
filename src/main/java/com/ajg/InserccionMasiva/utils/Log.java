package com.ajg.InserccionMasiva.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class Log {

    private static final DateTimeFormatter F =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Log(){}

    public static void info(String msg) {
        log.info("[INFO] "
                + LocalDateTime.now().format(F)
                + " - " + msg);
    }

    public static void error(String msg, Exception e) {
        log.error("[ERROR] "
                + LocalDateTime.now().format(F)
                + " - " + msg);

        if (e != null)
            e.printStackTrace();
    }
}

