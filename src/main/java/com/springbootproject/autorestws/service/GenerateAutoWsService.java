package com.springbootproject.autorestws.service;

import com.springbootproject.autorestws.components.ZipDownloader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class GenerateAutoWsService {

    @Autowired
    private ZipDownloader zipDownloader;

    public void execute() throws IOException {
        zipDownloader.downloadZipFile("https://start.spring.io/starter.zip?type=maven-project&language=java&platformVersion=2.7.11&packaging=jar&jvmVersion=1.8&groupId=com.ozge&artifactId=denemeapi&name=denemeapi&description=Demo%20project%20for%20Spring%20Boot&packageName=com.ozge.denemeapi", "myProjectdeneme.zip");
        log.info("Created Project.");
    }
}