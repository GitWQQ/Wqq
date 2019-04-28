package org.ssm.dufy.util;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.druid.support.json.JSONWriter;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CacheUtils {
	
	public static String toJsonString(String key){
		JSONWriter writer=new JSONWriter();
		writer.writeObject(key);
		return writer.toString();
	}

	public static <V> String toJsonString(V value) {
		return null;
	}
	
	public static Object jsonParseObject(String value){
		JSONParser parser=new JSONParser(value);
		return parser.parse();
	}
	
	public static void main(String[] args) {
		System.out.println(jsonParseObject("1111"));
	}
}
