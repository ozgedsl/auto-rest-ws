package com.springbootproject.autorestws.service.concretes;

import com.springbootproject.autorestws.components.ZipDownloader;
import com.springbootproject.autorestws.config.FileConfig;
import com.springbootproject.autorestws.model.GenerateProjectRequestModel;
import com.springbootproject.autorestws.service.abstracts.JsonService;
import com.springbootproject.autorestws.utils.FileUtility;
import com.springbootproject.autorestws.utils.UnzipUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Slf4j
@Service
public class GenerateAutoWsService {

    @Autowired
    private ZipDownloader zipDownloader;

    @Autowired
    private SpringInitilazr springInitilazr;

    @Autowired
    private JsonService jsonService;

    @Autowired
    private TemplateService templateService;

    public void execute(GenerateProjectRequestModel generateProjectRequestModel)  {

        String projectName = generateProjectRequestModel.getProjectName();

        String jsonModel = generateProjectRequestModel.getJson();
        try{
            springInitilazr.execute(projectName,jsonModel);
            templateService.generateController(projectName);
            templateService.generateService(projectName);
            generateModel(projectName,jsonModel);

        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
    }

    public void generateModel(String projectName, String json) {


        new File(String.format(FileConfig.BASE_PATH + "\\projects\\%s\\src\\main\\java\\com\\rest\\customer", projectName)).mkdirs();
        String path = String.format(FileConfig.BASE_PATH + "\\projects\\%s\\src\\main\\java\\com\\rest\\customer", projectName);
        new File(path, "model").mkdirs();
        jsonService.jsonToJavaClass(json, path);
    }
}
