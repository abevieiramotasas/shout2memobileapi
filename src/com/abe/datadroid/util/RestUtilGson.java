package com.abe.datadroid.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import com.abe.API.Shout2Me;
import com.foxykeep.datadroid.exception.RestClientException;
import com.foxykeep.datadroid.network.NetworkConnection;
import com.foxykeep.datadroid.network.NetworkConnection.NetworkConnectionResult;

public class RestUtilGson implements RestUtil {

	public String makeSimpleGet(Map<String, String> params, String path)
			throws IllegalStateException, IOException, URISyntaxException,
			RestClientException {
		String fullPath = Shout2Me.PATH + path;
		NetworkConnectionResult wsResult = NetworkConnection
				.retrieveResponseFromService(fullPath,
						NetworkConnection.METHOD_GET, params);
		return wsResult.wsResponse;
	}

	public String makeSimplePost(Map<String, String> params, String path)
			throws IllegalStateException, IOException, URISyntaxException,
			RestClientException {
		String fullPath = Shout2Me.PATH + path;
		NetworkConnectionResult wsResult = NetworkConnection
				.retrieveResponseFromService(fullPath,
						NetworkConnection.METHOD_POST, params);
		return wsResult.wsResponse;
	}

}
