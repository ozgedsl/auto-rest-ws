package com.springbootproject.autorestws.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("file")
@Data
public class FileConfig {
    private String filePath;
    public  static  final String BASE_PATH = "C:\\Users\\seraf\\Desktop\\ws-projects";
    public  static  final String MODULE = "testapi";
    public  static  final String GROUP_NAME = "rest";
    public  static  final String PACKAGE_NAME = "demo";
}
