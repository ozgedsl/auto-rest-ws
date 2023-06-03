package com.springbootproject.autorestws.service.abstracts;


import com.springbootproject.autorestws.model.BotRequest;
import com.springbootproject.autorestws.model.ChatGptResponse;
import org.springframework.stereotype.Service;

@Service
public interface GPTService {
    ChatGptResponse askQuestion(BotRequest botRequest);
}
