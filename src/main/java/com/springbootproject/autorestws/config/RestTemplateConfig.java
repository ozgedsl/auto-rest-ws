package com.springbootproject.autorestws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /*
    TODO : dependency injection ile Uygulamada Resttemplate bir yerde bean ile tanımlanıp kullanılması daha esnek calısan kod demektir
     her sınıfta tek tek resttemplate cagrılması uygulamanın büyümesiyle karmaşık hale geliyormuş. (uygulamanın arka planda calısan kısmını etkiliyor anladığım.)
     */

    @Autowired
    private RestTemplateBuilder restTemplateBuilder; //bu kısım niye kırmızı anlamadım daha önce vermiyordu bunu

    @Bean
    public RestTemplate restTemplate() {
        return restTemplateBuilder.build();
    }
}
