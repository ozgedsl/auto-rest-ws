//package com.springbootproject.autorestws.service.concretes;
//
//import freemarker.template.Configuration;
//import freemarker.template.Template;
//
//import java.io.FileWriter;
//import java.io.StringWriter;
//import java.util.HashMap;
//
//public class TemplateService {
//
//    public void execute(){
//        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
//        String fileName = String.format(GeneratorModel.PROJECT_PATH +"%s\\src\\main\\java\\com\\yildizholding\\ocean\\%s\\config\\client\\%sController.java", projectName, module,sourceNameUp);
//
//        FileWriter myWriter = new FileWriter(fileName);
//        String projecetName = "";
//        String fieldType = "";
//
//
//        HashMap<String, Object> args = new HashMap<>();
//        args.put("projecetName", projecetName);
//        args.put("fieldType", fieldType);
//
//
//        String templateFile = "src/main/resources/templates/webServiceClient.ftl";
//        Template template = cfg.getTemplate(templateFile);
//        StringWriter stringWriter = new StringWriter();
//        try {
//            template.process(args, stringWriter);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//        }
//
//        myWriter.write(stringWriter.toString());
//        myWriter.close();
//        return stringWriter.toString();
//
//    }
//}
