package com.example.kafkademo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "gs1")
@PropertySource("file:gs1.properties")
public class Gs1PropertyConfig {
    private String image;
    private String state;
    private String angle;
}
