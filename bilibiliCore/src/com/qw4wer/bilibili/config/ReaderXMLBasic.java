package com.qw4wer.bilibili.config;

import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ReaderXMLBasic {
	public static Element loaderAndgetRoot(InputStream in) {
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			doc = reader.read(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Element rootElement = doc.getRootElement();
		return rootElement;
	}

	public static Element loaderAndgetRoot(String file) {
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			doc = reader.read(file);

		} catch (Exception e) {
			e.printStackTrace();
		}
		Element rootElement = doc.getRootElement();
		return rootElement;
	}

}
