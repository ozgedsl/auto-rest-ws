package com.springbootproject.autorestws.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("file")
@Data
public class FileConfig {
    private String filePath;
}
