package com.qw4wer.bilibili.test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.qw4wer.bilibili.entity.View;
import com.qw4wer.bilibili.until.BilibiliApi;

public class Test1 {

	private JSONObject toByteArrayOutputStream(String path) {
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		URL url;
		try {
			url = new URL(path);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url
					.openConnection();
			httpUrlConnection.setRequestProperty("UserAgent", "Bilibili Win Client/0.0.1(qw5wer@gmail.com)");
			if (httpUrlConnection.getResponseCode() != 200)
				throw new RuntimeException("无法连接");
			InputStream inputStream = httpUrlConnection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
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
	
	@SuppressWarnings("static-access")
	@Test
	public void test1() throws JSONException{
		JSONObject stc  = toByteArrayOutputStream(BilibiliApi.getMovieInfoPath("json", "8e9fc618fbd41e28", 777576, 1));
		System.out.println(stc);
		System.out.println(stc.get("offsite"));
		String offsite = stc.get("offsite").toString();
		offsite = (offsite.substring(offsite.indexOf("=")+1,offsite.indexOf("&")));
		System.out.println(offsite);
		View v = (View) JSONObject.toBean(stc, View.class);
		System.out.println(v.getOffsite());
		
		System.out.println("aid"+v.getAid());
		
		System.out.println(BilibiliApi.getPlayUrl(v.getCid(), v.getAid()));
	}
}
