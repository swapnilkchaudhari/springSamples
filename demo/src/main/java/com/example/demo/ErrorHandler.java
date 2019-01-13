package com.example.demo;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorHandler implements ErrorController {

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping("/error")
	public @ResponseBody String name() {
		return "<html><body><h1>Hi, This is Swapnil's server. You are having error page.</h1></body></html>";
	}
}
