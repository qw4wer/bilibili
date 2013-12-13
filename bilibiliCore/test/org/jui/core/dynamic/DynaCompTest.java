package org.jui.core.dynamic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.qw4wer.bilibili.config.ReaderConfig;
import com.qw4wer.bilibili.until.CreateJava;

public class DynaCompTest {
	
	public static Map<String,Class<? extends Object>> maps;
	
	public static void main(String[] args) throws Exception {

		ReaderConfig config = new ReaderConfig();
		Set<Entry<String, Map<String, String>>> s = config.fileds.entrySet();
		Map<String, String> filed = null;
		for (Entry<String, Map<String, String>> entry : s) {
			filed = entry.getValue();

		}
		CreateJava createJava = new CreateJava("View",
				"/src/com/qw4wer/bilibili/entity", filed);
		System.out.println(createJava.createString());
		DynamicEngine de = DynamicEngine.getInstance();
		Object instance = de.javaCodeToObject("View", createJava.createString()
				.toString());
		//测试构造器
		System.out.println(instance.getClass().getConstructor());


		//得到
		Constructor constructor = instance.getClass().getConstructor();
		Object object =  constructor.newInstance();
		
		Method setPlay = object.getClass().getDeclaredMethod("setPlay", Integer.class);
		setPlay.invoke(object, 10);
		
		Method getPlay = object.getClass().getDeclaredMethod("getPlay", null);
		System.out.println(getPlay.invoke(object, null));
		System.out.println(instance);
		//调用class.forName()加载测试
		
//		Class.forName(object.getClass().getName());
		System.out.println(instance.getClass().getPackage());

	}
	
	public void init(){
		
	}
}
