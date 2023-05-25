package com.springbootproject.autorestws.service.concretes;

import com.springbootproject.autorestws.components.ZipDownloader;
import com.springbootproject.autorestws.model.GenerateProjectRequestModel;
import com.springbootproject.autorestws.service.abstracts.ProjectGenerateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class ProjectGenerateServiceImpl implements ProjectGenerateService {

    @Autowired
    private ZipDownloader zipDownloader;

    @Override
    public Object springInitGenerateProject(GenerateProjectRequestModel generateProjectRequestModel) {
        String queryForURL = "";
//        type="+generateProjectRequestModel.getType()
//                +"&language="+generateProjectRequestModel.getLanguage()
//                +"&platformVersion="+generateProjectRequestModel.getPlatformVersion()
//                +"&packaging="+generateProjectRequestModel.getPackaging()
//                +"&jvmVersion="+generateProjectRequestModel.getJvmVersion()
//                +"&groupId="+generateProjectRequestModel.getGroupId()
//                +"&artifactId="+generateProjectRequestModel.getArtifactId()
//                +"&name="+generateProjectRequestModel.getName()
//                +"&description="+generateProjectRequestModel.getDescription()
//                +"&packageName="+generateProjectRequestModel.getPackageName()
//                +"";

        try {
                zipDownloader.downloadZipFile("https://start.spring.io/starter.zip?" + queryForURL, ""+".zip");
            log.info("Created Project.");
            return "ok";
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return "not ok";

        }

    }
}
