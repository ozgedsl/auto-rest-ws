package com.springbootproject.autorestws.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BotRequest  implements Serializable {
    private String message;

}
