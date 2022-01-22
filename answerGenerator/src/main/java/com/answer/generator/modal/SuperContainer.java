package com.answer.generator.modal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SuperContainer {

	private String question;
	private String answer;
	private String arabicAnswer;

	public String getArabicAnswer() {
		return arabicAnswer;
	}

	public void setArabicAnswer(String arabicAnswer) {
		this.arabicAnswer = arabicAnswer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public SuperContainer(String qustion, String answer, String arabicAnswer) {
		this.question = qustion;
		this.answer = answer;
		this.arabicAnswer = arabicAnswer;
	}

	public SuperContainer() {
	}

	int getNear(String question) {

		List<String> words = Arrays.asList(question.split(" "));
		List<String> keywords = Arrays.asList(this.question.split(" "));

		return getIntersection(removeDuplicated(keywords), removeDuplicated(words)).size();
	}

	public List<String> getIntersection(List<String> list1, List<String> list2) {
		List<String> result = new ArrayList<>();
		for (String item : list1) {
			if (list2.contains(item)) {
				result.add(item);
			}
		}

		return result;
	}

	public List<String> removeDuplicated(List<String> list) {
		return new ArrayList<>(new HashSet<>(list));
	}

	FinalAnswer getAnswer() {
		FinalAnswer answers = new FinalAnswer(question, answer, arabicAnswer);
		return answers;
	}

}
