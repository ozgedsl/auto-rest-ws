package com.springbootproject.autorestws.service;

import com.springbootproject.autorestws.components.ZipDownloader;
import com.springbootproject.autorestws.model.GenerateProjectRequestModel;
import com.springbootproject.autorestws.utils.UnzipUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class GenerateAutoWsService {

    @Autowired
    private ZipDownloader zipDownloader;

    public void execute(GenerateProjectRequestModel generateProjectRequestModel) throws IOException {

        String queryForURL = "type="+generateProjectRequestModel.getType()
                +"&language="+generateProjectRequestModel.getLanguage()
                +"&platformVersion="+generateProjectRequestModel.getPlatformVersion()
                +"&packaging="+generateProjectRequestModel.getPackaging()
                +"&jvmVersion="+generateProjectRequestModel.getJvmVersion()
                +"&groupId="+generateProjectRequestModel.getGroupId()
                +"&artifactId="+generateProjectRequestModel.getArtifactId()
                +"&name="+generateProjectRequestModel.getName()
                +"&description="+generateProjectRequestModel.getDescription()
                +"&packageName="+generateProjectRequestModel.getPackageName()
                +"";

        zipDownloader.downloadZipFile("https://start.spring.io/starter.zip?" + queryForURL, generateProjectRequestModel.getFileName()+".zip");
        log.info("Created Project.");
    }
}