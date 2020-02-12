package com.wallnet.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleResource {

	@Autowired
	private Environment env;
	
	@RequestMapping("/getstring")
	public String get() {
		return "Hello world from port" + env.getProperty("local.server.port");
	}
}
