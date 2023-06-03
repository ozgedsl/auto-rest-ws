package com.springbootproject.autorestws.controller;

import com.springbootproject.autorestws.model.BotRequest;
import com.springbootproject.autorestws.model.GenerateProjectRequestModel;
import com.springbootproject.autorestws.service.abstracts.JsonService;
import com.springbootproject.autorestws.service.concretes.GenerateAutoWsService;
import com.springbootproject.autorestws.service.concretes.GptTest;
import com.springbootproject.autorestws.service.concretes.SpringInitilazr;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
@Slf4j
public class TestController {

    @Autowired
    private GenerateAutoWsService generateAutoWsService;

    @Autowired
    private JsonService jsonService;

    @Autowired
    private SpringInitilazr springInitilazr;

    @Autowired
    private GptTest gptTest;


    @PostMapping("/generate-project")
    public void execute(GenerateProjectRequestModel generateProjectRequestModel) {
        try {
            //gpt servisini kullanırken çok fazla istek atmamaya dikkat edelim her istek için 0.01 cent ücret alıyor :))
           generateAutoWsService.execute(generateProjectRequestModel);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @PostMapping("/testGpt")
    public String testGpt(BotRequest request){
       return gptTest.testGpt(request);
    }

//    @PostMapping("/jsonToProject")
//    public Object jsonToProject(String json) {
//        return jsonService.jsonToJavaClass(json);
//    }
}
