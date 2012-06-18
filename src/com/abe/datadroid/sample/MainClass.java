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
		List<MessageIn> resultado = (JSONUtil.fromJSON(json,
				MessageWrapper.class)).getMessageIn();

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
