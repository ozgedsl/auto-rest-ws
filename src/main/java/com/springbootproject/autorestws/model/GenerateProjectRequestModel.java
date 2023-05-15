package com.springbootproject.autorestws.model;

import lombok.Data;

@Data
public class GenerateProjectRequestModel {
    private String type;
    private String language;
    private String platformVersion;
    private String packaging;
    private String jvmVersion;
    private String groupId;
    private String artifactId;
    private String name;
    private String description;
    private String packageName;
    private String fileName;
}
