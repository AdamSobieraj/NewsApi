package com.example.newsfinder.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "core")
public class ApplicationConfiguration {

    private String apiKey;

}
