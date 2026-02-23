package com.ajg.InserccionMasiva.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;

import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PrintProperties {

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {

        String banner =
                "\n#########################################################################################";

        String bannerHead =
                "\n########################<< MICRO-SERVICE CONFIGURATION AJG>>################################";

        
		log.info("{}{}{}", banner, bannerHead, banner);

        ConfigurableEnvironment env =
                (ConfigurableEnvironment) event.getApplicationContext().getEnvironment();

        log.info("Active profiles: {}", Arrays.toString(env.getActiveProfiles()));

        Map<String, String> map =
                env.getPropertySources()
                .stream()
                .filter(ps -> ps instanceof MapPropertySource &&
                        ps.getName().contains("application"))
                .map(ps -> ((MapPropertySource) ps).getSource().keySet())
                .flatMap(Collection::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toMap(prop -> prop, env::getProperty));

        log.info("\n{}",
                new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(map));

        log.info("{}{}", banner, banner);

    }

}
