package com.sammeta.gusto.springboot.gustosb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppHealthCheckController {
	

	private static final String template = "Hellos, %s!";

	@GetMapping("/healthcheck" )
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format(template, name);
	}
}