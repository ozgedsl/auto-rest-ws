package com.springbootproject.autorestws.service.abstracts;

import org.springframework.stereotype.Service;

@Service
public interface JsonService {

    String jsonToJavaClass(String json);

}
