package com.springbootproject.autorestws.service.concretes;

import com.springbootproject.autorestws.model.BotRequest;
import com.springbootproject.autorestws.model.ChatGptResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GptTest {

    @Autowired
    private GPTServiceImpl gptService;

    @Autowired
    private JSONExtractor jsonExtractor;

    public String testGpt(BotRequest request){
        ChatGptResponse chatGptResponse = gptService.askQuestion(request);
        String response = chatGptResponse.getChoices().get(0).getText();
        log.info("json: "+jsonExtractor.extractJSON(response));
       return jsonExtractor.extractJSON(response);
    }
}
