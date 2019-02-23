package com.example.eurekaClientVerb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NounController {

	@Value("${words}")
	String wordString;
	
	@RequestMapping(method=RequestMethod.GET, path="/Noun")
	public String getNoun() {
		String[] words=wordString.split(",");
		int index=(int)Math.round(Math.random()*(words.length-1));
		return words[index];
	}
}
