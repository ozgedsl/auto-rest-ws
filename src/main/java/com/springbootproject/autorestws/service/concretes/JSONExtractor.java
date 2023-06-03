package com.springbootproject.autorestws.service.concretes;


import org.springframework.stereotype.Service;

@Service
public class JSONExtractor {
    public  String extractJSON(String text) {
        int startIndex = text.indexOf("{");
        int endIndex = text.lastIndexOf("}");

        if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
            String jsonText = text.substring(startIndex, endIndex + 1);
            return jsonText;
        }

        return "json model bulunamadı"; // JSON modeli bulunamadı
    }
}