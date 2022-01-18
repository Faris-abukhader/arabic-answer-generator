package com.answer.generator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.answer.generator.modal.MapContainer;
import com.answer.generator.modal.SuperContainer;

@Service
public class MyService {

	private HashMap<String, MapContainer> data = new HashMap<>();
	private List<String> keywordStrings = Arrays.asList("name", "nationality");

	public MyService() {
		readData();
	}

	public String getAnswer(String question) {
		int i;
		for (i = 0; i < keywordStrings.size(); i++) {
			if (question.contains(keywordStrings.get(i))) {
				break;
			}
		}
		return data.get(keywordStrings.get(i)).getAnswerFor(question);
	}

	public void readData() {
		JSONParser parser = new JSONParser();
		JSONArray a;
		try {
			a = (JSONArray) parser.parse(new FileReader("src/main/resources/static/test.json"));
			for (Object o : a) {
				JSONObject person = (JSONObject) o;

				String key = (String) person.get("key");

				JSONArray data_list = (JSONArray) person.get("data_list");

				List<SuperContainer> superContainer = new ArrayList<>();

				for (Object object : data_list) {
					JSONObject container = (JSONObject) object;
					String question = (String) container.get("question");
					String answer = (String) container.get("answer");
					superContainer.add(new SuperContainer(question, answer));
				}

				MapContainer map1 = new MapContainer(superContainer);

				data.put(key, map1);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
