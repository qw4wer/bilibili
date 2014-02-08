package com.qw4wer.bilibili.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qw4wer.bilibili.config.ReaderConfig;

public class UrlUtils {
	private static Map<String, String> config = ReaderConfig.config;

	/**
	 * 根据参数得到url
	 * @param type
	 * @param parameters
	 * @return
	 */
	public static String getUrlForParameters(String type,
			Map<String, Object> parameters) {
		String basicUrl = config.get(type);
		for (String key : parameters.keySet()) {
			basicUrl = basicUrl.replace("%" + key, parameters.get(key)
					.toString());
		}
		System.out.println(basicUrl);
		return basicUrl;
	}

	/**
	 * 根据参数得到url
	 * @param type
	 * @param parameters
	 * @return
	 */
	public static String getUrlForParameters(String type,
			List<Object> parameters) {
		String basicUrl = config.get(type);
		StringBuilder url = new StringBuilder(basicUrl);
		System.out.println(basicUrl);
		int j = 0;
		for (int i = 0; i < url.toString().length(); i++) {
			if ("=".equals(url.toString().charAt(i) + "")) {
				url.insert(i + 1, parameters.get(j));
				j++;
			}
		}
		System.out.println(url.toString());
		return "";
	}

	/**
	 * 得到viewUrl
	 * @param type
	 * @param appkey
	 * @param id
	 * @param page
	 * @return
	 */
	public static String getViewUrl(String type, String appkey, int id, int page) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("appkey", appkey);
		map.put("id", id);
		map.put("page", page);
		return getUrlForParameters("view", map);
	}
}
