package com.mts.mts_case.conf;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {
    @Bean
    public Map<String, Integer> cities() {
        Map<String, Integer> cities = new HashMap<>();
        cities.put("Moscow", 0);
        cities.put("SBP", 0);
        cities.put("Novosibirsk", 0);
        cities.put("ECB", 0);
        return cities;
    }
}
