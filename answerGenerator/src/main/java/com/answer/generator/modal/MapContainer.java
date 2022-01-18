package com.answer.generator.modal;

import java.util.ArrayList;
import java.util.List;

public class MapContainer {

	List<SuperContainer> containers = new ArrayList<SuperContainer>();

	public MapContainer(List<SuperContainer> containeres) {
		this.containers.addAll(containeres);
	}

	public String getAnswerFor(String question) {
		int max = containers.get(0).getNear(question), index = 0;
		for (int i = 0; i < containers.size(); i++) {
			if (containers.get(i).getNear(question) > max) {
				max = containers.get(i).getNear(question);
				index = i;
			}
		}
		return containers.get(index).getAnswer();
	}

}
