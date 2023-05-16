package com.restapi.${projectName}.controller;

import org.springframework.web.bind.annotation.*;
import com.restapi.${projectName}.service.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1")
public class MainController {

@Autowired
public {projectName}Service service;


@${MethodType}("/${get}${jsonModelParentName}")
public ${fieldType} get${jsonModelParentName}(){

return service.execute();

}

}
