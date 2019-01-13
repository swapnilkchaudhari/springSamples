package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello{
	
	@RequestMapping(method=RequestMethod.GET,value= {"/","/index1"})
	public @ResponseBody String hello() {
		return "<html><body><h1>Hi, This is Swapnil's server.</h1></body></html>";
	}
	
	/*@RequestMapping(value= {"/error"})
	public @ResponseBody String error() {
		return "<html><body><h1>Hi, This is Swapnil's server. You are having error page.</h1></body></html>";
	}*/
}
