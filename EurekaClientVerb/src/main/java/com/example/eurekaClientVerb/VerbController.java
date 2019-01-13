package com.example.eurekaClientVerb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerbController {
	
	@Value("${words}")
	String verbString;
	
	@GetMapping("/")
	public String getVerb() {
		String[] verbs=verbString.split(",");
		int index=(int)(Math.round(Math.random()*(verbs.length-1)));
		return verbs[index];
	}
}
