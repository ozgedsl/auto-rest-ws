package com.springbootproject.autorestws.service.concretes;

import com.springbootproject.autorestws.config.FileConfig;
import com.springbootproject.autorestws.service.abstracts.JsonService;
import com.sun.codemodel.JCodeModel;
import lombok.extern.slf4j.Slf4j;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@Slf4j
public class JsonServiceImpl implements JsonService {
    @Autowired
    private FileConfig fileConfig;


    @Override
    public String jsonToJavaClass(String json,String path) {
        try {
            JCodeModel jcodeModel = new JCodeModel();
            String javaClassName = "Customers";
            String packageName = "model";

            GenerationConfig config = new DefaultGenerationConfig() {
                @Override
                public boolean isGenerateBuilders() {
                    return true;
                }

                @Override
                public SourceType getSourceType() {
                    return SourceType.JSON;
                }
            };

            SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
            mapper.generate(jcodeModel, javaClassName, packageName,json);

            jcodeModel.build(new File(path));

            return "ok";
    } catch (Exception e){
            log.error(e.getMessage(),e);
            return "not ok";
        }

    }

}
