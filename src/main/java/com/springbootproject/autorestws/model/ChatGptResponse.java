package com.springbootproject.autorestws.model;

import lombok.Data;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@Data
public class ChatGptResponse implements Serializable {
    private String id;
    private String object;
    private LocalDate created;
    private String model;
    private List<Choice> choices;
}
