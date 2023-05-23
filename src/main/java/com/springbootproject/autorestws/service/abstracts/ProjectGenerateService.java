package com.springbootproject.autorestws.service.abstracts;

import com.springbootproject.autorestws.model.GenerateProjectRequestModel;
import org.springframework.stereotype.Service;

@Service
public interface ProjectGenerateService {

    Object springInitGenerateProject(GenerateProjectRequestModel generateProjectRequestModel);

}
