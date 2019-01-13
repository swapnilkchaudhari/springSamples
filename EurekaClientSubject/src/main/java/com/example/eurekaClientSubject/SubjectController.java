package com.example.eurekaClientSubject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {

	@Value("${words})")
	String wordString;
	@RequestMapping(method=RequestMethod.GET, path="/")
	public String getSubject() {
		String[] words=wordString.split(",");
		int index=(int)Math.round(Math.random()*(words.length-1));
		return words[index];
	}
}
