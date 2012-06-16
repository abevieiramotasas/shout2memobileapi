package com.abe.API;

import java.io.IOException;
import java.net.URISyntaxException;
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
import com.foxykeep.datadroid.exception.RestClientException;

public class Shout2Me {

	@SuppressWarnings("unused")
	private static String developerKey = "";
	public static final String PATH = "http://shout2megae.appspot.com/";

	public static List<IslandIn> getIslands(Double longitude, Double latitude,
			Double distance, Integer max_results) throws IllegalStateException,
			IOException, URISyntaxException, RestClientException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("longitude", String.valueOf(longitude));
		params.put("latitude", String.valueOf(latitude));
		params.put("distance", String.valueOf(distance));
		params.put("max_results", String.valueOf(max_results));
		String result = RestUtil.makeSimpleGet(params, "island/getAll");
		List<IslandIn> islands = JSONUtil.fromJSON(result, IslandWrapper.class)
				.getIslands();
		return islands;
	}

	public static IslandIn getIslandById(Long island_id)
			throws IllegalStateException, IOException, URISyntaxException,
			RestClientException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(island_id));
		String result = RestUtil.makeSimpleGet(params, "island");
		return JSONUtil.fromJSON(result, IslandIn.class);
	}

	/**
	 * 
	 * @return returns user's key
	 * @throws RestClientException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	public static String createUser(User u) throws IllegalStateException,
			IOException, URISyntaxException, RestClientException {
		return RestUtil.makeSimplePost(u.getAttributesAsMap(), "user/create");
	}

	public static List<MessageIn> getAllMessageByIsland(Long destination_id,
			Integer limit, Long base_date_in_millis, Boolean up)
			throws IllegalStateException, IOException, URISyntaxException,
			RestClientException {

		Map<String, String> params = new HashMap<String, String>();
		params.put("destination_id", String.valueOf(destination_id));
		params.put("limit", String.valueOf(limit));
		params.put("base_date_in_millis", String.valueOf(base_date_in_millis));
		params.put("up", String.valueOf(up));

		String result = RestUtil.makeSimpleGet(params, "message/getAll");
		List<MessageIn> messages = JSONUtil.fromJSON(result,
				MessageWrapper.class).getMessageIn();
		return messages;
	}

	/**
	 * 
	 * @param mail
	 * @param password
	 * @return returns user's key
	 * @throws RestClientException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	public static String login(String mail, String password)
			throws IllegalStateException, IOException, URISyntaxException,
			RestClientException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("mail", mail);
		params.put("password", password);

		return RestUtil.makeSimplePost(params, "login");
	}

	/**
	 * 
	 * @param i
	 * @param key
	 * @return returns island's id
	 * @throws RestClientException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	public static String createIsland(Island i, String key)
			throws IllegalStateException, IOException, URISyntaxException,
			RestClientException {
		Map<String, String> params = i.getAttributesAsMap();
		params.put("key", key);
		return RestUtil.makeSimplePost(params, "island/create");
	}

	public static void sendMessage(Message m, String key)
			throws IllegalStateException, IOException, URISyntaxException,
			RestClientException {
		Map<String, String> params = m.getAttributesAsMap();
		params.put("key", key);
		RestUtil.makeSimplePost(params, "message/create");
	}

}
