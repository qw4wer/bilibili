package org.jui.core.dynamic;

import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;

import com.qw4wer.bilibili.entity.View;

public class TestClass {

	public static void main(String[] args) throws Exception {
		View view1 = new View();
		view1.setCid(10);
		View view2 = new View();
		view1.setCid(100);
		Map<String,Object> last = getMap(view1);
		Map<String,Object> now = getMap(view2);
		
		Map<String,String> change = new HashMap<String, String>(); 
		Field[] fields = view1.getClass().getDeclaredFields();
		for (Field f : fields) {
			if((last.get(f.getName())).equals(now.get(f.getName()))){
				change.put(f.getName(), last.get(f.getName())+"->"+now.get(f.getName()));
			}
			
		}
		
		System.out.println(change.isEmpty());
	}
	
	public static Map<String,Object> getMap(Object obj) throws Exception{
		Field[] fields = obj.getClass().getDeclaredFields();
		Map<String,Object> maps = new HashMap<String, Object>();
		for (Field field : fields) {
			maps.put(field.getName(), PropertyUtils.getProperty(obj, field.getName()));
		}
		return maps;
	} 
}
