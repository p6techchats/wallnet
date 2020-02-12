package com.walnet.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleResource {

	@RequestMapping("/getstring")
	public String get() {
		return "Hello world";
	}
}
