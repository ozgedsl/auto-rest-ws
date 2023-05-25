package com.rest.${package}.controller;

import org.springframework.web.bind.annotation.*;
import com.rest.${package}.service.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1")
public class MainController {

@Autowired
public CustomerService service;


@${MethodType}("/get${jsonModelParentName}")
public ${fieldType} get${jsonModelParentName}(){

return service.execute();

}

}
