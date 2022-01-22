package com.answer.generator.modal;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MapContainer {

	List<SuperContainer> containers = new ArrayList<SuperContainer>();

	public MapContainer(List<SuperContainer> containeres) {
		this.containers.addAll(containeres);
	}

	public FinalAnswer getAnswerFor(String question) {
		int max = containers.get(0).getNear(question), index = 0;
		for (int i = 0; i < containers.size(); i++) {
			if (containers.get(i).getNear(question) > max) {
				log.info("the question for answer is " + containers.get(i));
				max = containers.get(i).getNear(question);
				index = i;
			}
		}
		return containers.get(index).getAnswer();
	}

}
