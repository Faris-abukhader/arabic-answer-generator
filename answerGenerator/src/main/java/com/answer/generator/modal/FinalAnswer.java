package com.answer.generator.modal;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class FinalAnswer {
	private String question;
	private String englishAnswer;
	private String arabicAnswer;

}
