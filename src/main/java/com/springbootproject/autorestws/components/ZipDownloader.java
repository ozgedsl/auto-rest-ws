package com.springbootproject.autorestws.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

@Component
public class ZipDownloader {

    private final RestTemplate restTemplate;

    @Autowired
    public ZipDownloader(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void downloadZipFile(String url, String fileName) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_OCTET_STREAM));

        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET,
                new HttpEntity<>(headers), byte[].class);

        if (response.getStatusCode() == HttpStatus.OK) {
            ByteArrayResource resource = new ByteArrayResource(response.getBody());
            Path path = Paths.get("C:\\Users\\ozgenur.dasli\\MyProjects\\auto-rest-ws\\src\\main\\java\\com\\springbootproject\\autorestws\\file\\" +fileName);
            FileOutputStream fos = new FileOutputStream(path.toFile());
            fos.write(resource.getByteArray());
            fos.close();
        }
    }
}
