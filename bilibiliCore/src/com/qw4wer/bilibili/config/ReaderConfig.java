package com.qw4wer.bilibili.config;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.dom4j.Element;

/**
 * ��ȡ�����ļ�
 * 
 * @author qw4wer
 * @version 0.0.1
 * 
 */
public class ReaderConfig extends ReaderXMLBasic {

	private static InputStream in;

	private static Element root = null;

	public static final Map<String, String> config;

	public static final Map<String, Map<String, String>> fileds;
	static {
		in = ReaderConfig.class.getClassLoader().getResourceAsStream(
				"config.xml");
		root = loaderAndgetRoot(in);
		config = new HashMap<String, String>();
		fileds = new HashMap<String, Map<String, String>>();
		reader();
		// t();
	}

	// TODO δ���
	@SuppressWarnings("unchecked")
	private static void reader() {
		// ��ȡapi
		List<Element> apis = root.element("apis").elements();
		for (Element e : apis) {
			// ��ȡurl
			config.put(e.getName(), e.element("url").getData().toString());
			// ��ʼ��
			List<Element> rs = e.element("return").elements("r");
			Map<String, String> temp = new HashMap<String, String>();
			for (Element element : rs) {
				temp.put(element.attributeValue("name"),
						element.attributeValue("type"));
			}
			fileds.put(e.getName(), temp);
			
		}

		// ��ȡ�������·��
		List<Element> nets = root.element("nets").elements();
		for (Element e : nets) {
			config.put(e.getName(), e.getData().toString());
		}
	}



	public static void main(String[] args) {
		 new ReaderConfig();
		 Set<Entry<String, Map<String,String>>> s= fileds.entrySet();
		for (Entry<String, Map<String, String>> entry : s) {
			System.out.println(entry.getKey());
			for (Entry<String,String> e: entry.getValue().entrySet()) {
				System.out.println(e.getKey()+"\t"+e.getValue());
			}
		}
	}
}
