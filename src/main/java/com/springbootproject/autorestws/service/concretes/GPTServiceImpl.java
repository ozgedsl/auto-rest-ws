package com.springbootproject.autorestws.service.concretes;

import com.springbootproject.autorestws.config.ChatGptConfig;
import com.springbootproject.autorestws.model.BotRequest;
import com.springbootproject.autorestws.model.ChatGptRequest;
import com.springbootproject.autorestws.model.ChatGptResponse;
import com.springbootproject.autorestws.service.abstracts.GPTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;


@Slf4j
@Service
public class GPTServiceImpl implements GPTService {
    private static RestTemplate restTemplate = new RestTemplate();

    public HttpEntity<ChatGptRequest> buildHttpEntity(ChatGptRequest chatRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(ChatGptConfig.MEDIA_TYPE));
        headers.add(ChatGptConfig.AUTHORIZATION, ChatGptConfig.BEARER + ChatGptConfig.API_KEY);
        return new HttpEntity<>(chatRequest, headers);
    }

    public ChatGptResponse getResponse(HttpEntity<ChatGptRequest> chatRequestHttpEntity) {
        ResponseEntity<ChatGptResponse> responseEntity = restTemplate.postForEntity(
                ChatGptConfig.URL,
                chatRequestHttpEntity,
                ChatGptResponse.class);

        return responseEntity.getBody();
    }


    @Override
    public ChatGptResponse askQuestion(BotRequest botRequest) {
        log.info(botRequest.getMessage());
        return  this.getResponse(
                this.buildHttpEntity(
                        new ChatGptRequest(
                                ChatGptConfig.MODEL,
                                botRequest.getMessage(),
                                ChatGptConfig.TEMPERATURE,
                                ChatGptConfig.MAX_TOKEN,
                                ChatGptConfig.TOP_P)));
    }
}
