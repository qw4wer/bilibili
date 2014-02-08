package com.qw4wer.bilibili.common;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;

public class NetBase {
	/**
	 * 连接url,得到返回的json
	 * @param path
	 * @return
	 */
	public static JSONObject connectUrltoJSONObject(String path) {
		URL url;
		try {
			url = new URL(path);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url
					.openConnection();
			httpUrlConnection.setRequestProperty("UserAgent",
					"Bilibili Win Client/0.0.1(qw5wer@gmail.com)");
			if (httpUrlConnection.getResponseCode() != 200)
				throw new RuntimeException("无法连接");
			InputStream inputStream = httpUrlConnection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream);
			BufferedReader reader = new BufferedReader(inputStreamReader);
			String json = reader.readLine();
			JSONObject jsonObject = JSONObject.fromObject(json);
			reader.close();
			inputStream.close();
			httpUrlConnection.disconnect();
			return jsonObject;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
