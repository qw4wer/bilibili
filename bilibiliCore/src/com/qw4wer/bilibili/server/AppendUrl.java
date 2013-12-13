package com.qw4wer.bilibili.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.qw4wer.bilibili.config.ReaderConfig;

public class AppendUrl {
	private static Map<String, String> config = ReaderConfig.config;

	public static String getViewUrl(String type, String appkey, int av, int page) {
		
		return "";
	}

	private static String getUrlForParameters(String type,
			List<Object> parameters) {
		String basicUrl = config.get(type);
		StringBuilder url = new StringBuilder(basicUrl);
		System.out.println(basicUrl);
		int j=0;
		for (int i = 0; i < url.toString().length(); i++) {
			if("=".equals(url.toString().charAt(i)+"")){
				url.insert(i+1, parameters.get(j));
				j++;
			}
		}
		System.out.println(url.toString());
		return "";
	}
	
	@Test
	public void test(){
		List<Object> list = new ArrayList<Object>();
		list.add("xml");
		list.add("8e9fc618fbd41e28");
		list.add("78842");
		list.add("1");
		getUrlForParameters("view", list);
	}
}
