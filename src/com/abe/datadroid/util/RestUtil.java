package com.abe.datadroid.util;

import java.util.Map;

public interface RestUtil {

	public String makeSimplePost(Map<String, String> params, String path)
			throws Exception;

	public String makeSimpleGet(Map<String, String> params, String path)
			throws Exception;

}
