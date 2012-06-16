package com.abe.datadroid.util;

import com.google.gson.Gson;

public class JSONUtil {
	private static Gson gson = new Gson();

	public static String toJSON(Object o) {
		return gson.toJson(o);
	}

	public static <E> E fromJSON(String json, Class<E> classe) {
		return gson.fromJson(json, classe);
	}
}
