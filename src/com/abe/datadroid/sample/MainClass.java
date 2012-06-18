package com.abe.datadroid.sample;

import java.util.ArrayList;
import java.util.List;

import com.abe.API.Shout2Me;
import com.abe.API.model.IslandIn;
import com.abe.API.model.MessageIn;
import com.abe.API.model.MessageWrapper;
import com.abe.datadroid.util.JSONUtil;

public class MainClass {

	public static void main(String[] args) {

		// testando gson
		List<MessageIn> messages = new ArrayList<MessageIn>();
		MessageIn m = null;
		for (int i = 0; i < 10; i++) {
			m = new MessageIn();
			m.setText("brincando" + i);
			m.setAuthor_name("Abelardo" + i);
			messages.add(m);
		}
		MessageWrapper mw = new MessageWrapper();
		mw.setMessageIn(messages);
		String json = JSONUtil.toJSON(mw);

		json = "{\"message\":[{\"author_id\":\"14002\",\"author_name\":\"saulo dev\",\"date_in_millis\":\"1339475083513\",\"destination_id\":\"10001\",\"message_id\":\"9001\",\"text\":\"adfafs\",\"topic\":\"fhuiaheufe\"},{\"author_id\":\"9001\",\"author_name\":\"Abelardo\",\"date_in_millis\":\"1339181877528\",\"destination_id\":\"10001\",\"message_id\":\"8001\",\"text\":\"Testando as Mensagens\",\"topic\":\"Topico ou tags\"},{\"author_id\":\"9001\",\"author_name\":\"Abelardo\",\"date_in_millis\":\"1339181875981\",\"destination_id\":\"10001\",\"message_id\":\"7001\",\"text\":\"Testando as Mensagens\",\"topic\":\"Topico ou tags\"},{\"author_id\":\"9001\",\"author_name\":\"Abelardo\",\"date_in_millis\":\"1339181874261\",\"destination_id\":\"10001\",\"message_id\":\"6001\",\"text\":\"Testando as Mensagens\",\"topic\":\"Topico ou tags\"},{\"author_id\":\"9001\",\"author_name\":\"Abelardo\",\"date_in_millis\":\"1339181872503\",\"destination_id\":\"10001\",\"message_id\":\"5001\",\"text\":\"Testando as Mensagens\",\"topic\":\"Topico ou tags\"},{\"author_id\":\"9001\",\"author_name\":\"Abelardo\",\"date_in_millis\":\"1339181869234\",\"destination_id\":\"10001\",\"message_id\":\"4001\",\"text\":\"Testando as Mensagens\",\"topic\":\"Topico ou tags\"}]}";

		List<MessageIn> resultado = (JSONUtil.fromJSON(json,
				MessageWrapper.class)).getMessageIn();
		// fim teste

		List<IslandIn> islands = null;
		try {
			Double longitude = 10.12;
			Double latitude = 20.23;
			Double distance = 1000000.0;
			Integer max_results = 20;
			islands = Shout2Me.getIslands(longitude, latitude, distance,
					max_results);
		} catch (Exception e) {

		}
		for (IslandIn i : islands) {
			System.out.println(i);
		}
	}

}
