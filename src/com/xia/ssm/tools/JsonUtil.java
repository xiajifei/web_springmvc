package com.xia.ssm.tools;


import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/** 
* @author Jia Qiang
* @version ����ʱ�䣺2016��6��23�� ����3:11:07 
* ��˵�� 
*/
public class JsonUtil {
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	public static final <T> T jsonToObject( String json, Class<T> clas){
		try {
			return mapper.readValue(json, clas);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static final <T> T jsonToObject( byte[] data, Class<T> clas){
		try {
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(data, clas);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static final String objectToJson( Object obj ) {
		try {
			return mapper.writeValueAsString( obj );
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}  
		return null;
	}
}
