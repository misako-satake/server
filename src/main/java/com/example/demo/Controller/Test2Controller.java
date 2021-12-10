package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Test2Controller {

	@RequestMapping("/test")
	public String test2() {
		return "test";
	}
	
}
