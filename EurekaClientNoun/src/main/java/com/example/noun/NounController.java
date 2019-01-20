package com.example.noun;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NounController {
    @Value("${words}")
    String words;

    @GetMapping(path = "/Noun")
    public String getWord() {
        String[] wordArray=words.split(",");
        int index=(int)Math.round(Math.random()*(wordArray.length-1));
        return wordArray[index];
    }
}
