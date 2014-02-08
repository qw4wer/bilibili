package com.qw4wer.bilibili.test;

import org.junit.Test;

import com.qw4wer.bilibili.common.UrlUtils;

public class TestUrlUtils {

	@Test
	public void t1(){
		UrlUtils.getViewUrl("json", "8e9fc618fbd41e28", 544575, 1);
	}
}
