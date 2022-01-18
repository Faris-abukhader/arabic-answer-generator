package com.answer.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get-answer")
public class DataController {

	@Autowired
	private MyService myService;

	@GetMapping("{question}")
	public String getAnswer(@PathVariable("question") String question) {
		return myService.getAnswer(question);
	}

}
