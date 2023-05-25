package com.springbootproject.autorestws.service.concretes;

import com.springbootproject.autorestws.config.FileConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

@Service
@Slf4j
public class TemplateService {


    public String generateController(String projectName) throws IOException {
        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        new File(String.format(FileConfig.BASE_PATH + "\\projects\\%s\\src\\main\\java\\com\\rest\\customer\\controller", projectName)).mkdirs();
        String fileName = String.format(FileConfig.BASE_PATH + "\\projects\\%s\\src\\main\\java\\com\\rest\\customer\\controller\\MainController.java", projectName);

        FileWriter myWriter = new FileWriter(fileName);
        String fieldType = "Object";
        String jsonModelParentName = "";
        String methodType = "GetMapping";


        HashMap<String, Object> args = new HashMap<>();
        args.put("MethodType", methodType);
        args.put("jsonModelParentName", jsonModelParentName);
        args.put("fieldType", fieldType);
        args.put("package", "customer");


        String templateFile = "src/main/resources/templates/mainControllerTemplate.ftl";
        Template template = cfg.getTemplate(templateFile);
        StringWriter stringWriter = new StringWriter();
        try {
            template.process(args, stringWriter);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        myWriter.write(stringWriter.toString());
        myWriter.close();
        return stringWriter.toString();

    }

    public String generateService(String projectName) throws IOException {
        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        new File(String.format(FileConfig.BASE_PATH + "\\projects\\%s\\src\\main\\java\\com\\rest\\customer\\service", projectName)).mkdirs();
        String fileName = String.format(FileConfig.BASE_PATH + "\\projects\\%s\\src\\main\\java\\com\\rest\\customer\\service\\CustomerService.java", projectName);

        FileWriter myWriter = new FileWriter(fileName);
        String className = "Customer";
       String fieldType = "Object";

        HashMap<String, Object> args = new HashMap<>();
        args.put("package", "customer");
        args.put("className", className);
        args.put("fieldType", fieldType);
        args.put("projectName", projectName);


        String templateFile = "src/main/resources/templates/serviceTemplate.ftl";
        Template template = cfg.getTemplate(templateFile);
        StringWriter stringWriter = new StringWriter();
        try {
            template.process(args, stringWriter);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        myWriter.write(stringWriter.toString());
        myWriter.close();
        return stringWriter.toString();

    }
}
