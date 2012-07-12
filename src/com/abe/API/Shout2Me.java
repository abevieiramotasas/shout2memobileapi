package com.abe.API;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.abe.API.model.Island;
import com.abe.API.model.IslandIn;
import com.abe.API.model.IslandWrapper;
import com.abe.API.model.Message;
import com.abe.API.model.MessageIn;
import com.abe.API.model.MessageWrapper;
import com.abe.API.model.User;
import com.abe.datadroid.util.JSONUtil;
import com.abe.datadroid.util.RestUtil;
import com.abe.datadroid.util.RestUtilGson;

public class Shout2Me {

	@SuppressWarnings("unused")
	private static String developerKey = "";
	public static final String PATH = "http://shout2megae.appspot.com/";
	public static final String LOCAL_PATH = "http://localhost:8888/";

	private static RestUtil restUtil = new RestUtilGson();

	public static List<IslandIn> getIslands(Double longitude, Double latitude,
			Double distance, Integer max_results) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("longitude", String.valueOf(longitude));
		params.put("latitude", String.valueOf(latitude));
		params.put("distance", String.valueOf(distance));
		params.put("max_results", String.valueOf(max_results));
		String result = restUtil.makeSimpleGet(params, "island/getall");
		System.out.println(result);
		List<IslandIn> islands = JSONUtil.fromJSON(result, IslandWrapper.class)
				.getIslands();
		return islands;
	}

	public static IslandIn getIslandById(Long island_id) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(island_id));
		String result = restUtil.makeSimpleGet(params, "island");
		return JSONUtil.fromJSON(result, IslandIn.class);
	}

	/**
	 * 
	 * @return returns user's key
	 * @throws Exception
	 */
	public static String createUser(User u) throws Exception {
		return restUtil.makeSimplePost(u.getAttributesAsMap(), "user/create");
	}

	/**
	 * 
	 * @param destination_id
	 * @param limit
	 * @param base_date_in_millis
	 * @param up
	 * @return
	 * @throws Exception
	 */
	public static List<MessageIn> getAllMessageByIsland(Long destination_id,
			Integer limit, Long base_date_in_millis, Boolean up)
			throws Exception {

		Map<String, String> params = new HashMap<String, String>();
		params.put("destination_id", String.valueOf(destination_id));
		params.put("limit", String.valueOf(limit));
		params.put("base_date_in_millis", String.valueOf(base_date_in_millis));
		params.put("up", String.valueOf(up));

		String result = restUtil.makeSimpleGet(params, "message/getall");
		List<MessageIn> messages = JSONUtil.fromJSON(result,
				MessageWrapper.class).getMessageIn();
		return messages;
	}

	/**
	 * 
	 * @param mail
	 * @param password
	 * @return returns user's key
	 * @throws Exception
	 */
	public static String login(String mail, String password) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("mail", mail);
		params.put("password", password);

		return restUtil.makeSimplePost(params, "login");
	}

	/**
	 * 
	 * @param i
	 * @param key
	 * @return returns island's id
	 * @throws Exception
	 */
	public static String createIsland(Island i, String key) throws Exception {
		Map<String, String> params = i.getAttributesAsMap();
		params.put("key", key);
		return restUtil.makeSimplePost(params, "island/create");
	}

	public static void sendMessage(Message m, String key) throws Exception {
		Map<String, String> params = m.getAttributesAsMap();
		params.put("key", key);
		restUtil.makeSimplePost(params, "message/create");
	}

}
