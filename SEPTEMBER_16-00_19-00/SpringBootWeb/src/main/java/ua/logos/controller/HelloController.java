package ua.logos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String sayHello() {
		return "Hello World";
	}
	
	@GetMapping("/start")
	public String start() {
		return "Start";
	}
	
	@GetMapping("/user/{userId}")
	public String getUser(@PathVariable("userId") String id) {
		return "User id = " + id;
	}
	
	//
}
