package com.example.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("test")
@Controller
public class MyController {

	private Logger logger=Logger.getRootLogger();
	
	@RequestMapping("hello")
	public String login() {
		logger.info("进入Hello界面...");
		System.out.println("修改了");
		return "Hello";
	}
}
