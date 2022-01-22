package com.answer.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.answer.generator.modal.FinalAnswer;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/get-answer")
@Log4j2
public class DataController {

	@Autowired
	private MyService myService;

	@GetMapping("{question}")
	public FinalAnswer getAnswer(@PathVariable("question") String question) {
		log.info("the question is " + question);
		return myService.getAnswer(question.toLowerCase());
	}

}
