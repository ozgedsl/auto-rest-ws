package com.springbootproject.autorestws.controller;

import com.springbootproject.autorestws.service.GenerateAutoWsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
@Slf4j
public class TestController {

    @Autowired
    private GenerateAutoWsService generateAutoWsService;

    @GetMapping("/generate-project")
    public void execute(){
        try {
            generateAutoWsService.execute();
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
    }
}