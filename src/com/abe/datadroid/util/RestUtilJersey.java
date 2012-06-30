package com.abe.datadroid.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import com.abe.API.Shout2Me;
import com.foxykeep.datadroid.exception.RestClientException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class RestUtilJersey implements RestUtil {

	public String makeSimpleGet(Map<String, String> params, String path)
			throws IllegalStateException, IOException, URISyntaxException,
			RestClientException {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(Shout2Me.PATH);
		WebResource builder = service.path(path);
		for (String key : params.keySet()) {
			builder = builder.queryParam(key, params.get(key));
		}
		String response = builder.accept(MediaType.APPLICATION_JSON).get(
				String.class);
		return response;
	}

	@Override
	public String makeSimplePost(Map<String, String> params, String path)
			throws Exception {
		return null;
	}
}
