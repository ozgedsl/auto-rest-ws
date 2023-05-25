package com.springbootproject.autorestws.service.concretes;

import com.google.gson.Gson;
import com.springbootproject.autorestws.config.FileConfig;
import com.springbootproject.autorestws.service.abstracts.JsonService;
import com.springbootproject.autorestws.utils.UnzipUtility;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SpringInitilazr {
    @Autowired
    private JsonService jsonService;


    public void execute(String projectName, String json) throws IOException {
        OkHttpClient client = new OkHttpClient();

        // YAML dosyasını yükle ve parametreleri al
        String yamlFilePath = "src/main/resources/service.yaml";
        Map<String, Object> yamlData = loadYamlFile(yamlFilePath);

        String baseUrl = "https://start.spring.io/starter.zip";

        // Parametreleri oluştur
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl).newBuilder();

        for (Map.Entry<String, Object> entry : yamlData.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key.equals("dependencies")) {
                if (value instanceof List) {
                    List<String> dependencies = new ArrayList<>();
                    for (Map<String, String> dependency : (List<Map<String, String>>) value) {
                        dependencies.add(dependency.get("name"));
                    }
                    String dependenciesString = String.join(",", dependencies);
                    urlBuilder.addEncodedQueryParameter(key, dependenciesString);
                }
            } else {
                urlBuilder.addQueryParameter(key, value.toString());
            }
        }


        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful()) {
            // Başarılı yanıt
            // ZIP dosyasını kaydetmek veya başka bir işlem yapmak için buraya kod ekleyebilirsiniz.
            String savePath = FileConfig.BASE_PATH + "\\zip\\project.zip";

            try (ResponseBody responseBody = response.body()) {
                if (responseBody != null) {
                    // ZIP dosyasını kaydet
                    Path filePath = Path.of(savePath);
                    Files.write(filePath, responseBody.bytes(), StandardOpenOption.CREATE);
                    System.out.println("ZIP dosyasi kaydedildi: " + savePath);

                    UnzipUtility.unzip(FileConfig.BASE_PATH + "\\zip\\project.zip", String.format(FileConfig.BASE_PATH + "\\projects\\%s", projectName));
                    log.info("modeller eklendi");
                }
            }
            System.out.println("Proje olusturuldu.");
        } else {
            // Başarısız yanıt
            System.out.println("Proje olusturulamadi. Hata kodu: " + response.code());
        }
    }


    public void generateModel(String projectName, String json) {


        String path = String.format(FileConfig.BASE_PATH + "\\projects\\%s\\src\\main\\java\\com\\rest\\customer", projectName);
        File modelPackage = new File(path, "model");
        jsonService.jsonToJavaClass(json, path);
    }

    private static Map<String, Object> loadYamlFile(String yamlFilePath) throws IOException {
        Yaml yaml = new Yaml();
        try (var inputStream = Files.newInputStream(Path.of(yamlFilePath))) {
            return yaml.load(inputStream);
        }
    }

    private String convertYamlToJson(Map<String, Object> yamlData) {
        // YAML dosyasını JSON formatına dönüştürmek için gerekli dönüşüm işlemleri
        // Burada bir JSON kütüphanesi (örneğin, Jackson) kullanabilirsiniz.
        // Bu örnekte, JSON dönüşümü yerine YAML verilerini doğrudan JSON formatında gönderiyoruz.

        return new Gson().toJson(yamlData);
    }
}
