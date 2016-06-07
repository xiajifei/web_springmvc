package com.xia.ssm.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.xia.ssm.po.User;
import com.xia.ssm.tools.DateUtil;
import com.xia.ssm.tools.JsonDateValueProcessor;
/**
 * JSON-lib包是一个beans,collections,maps,java arrays 
 * 和XML和JSON互相转换的包，主要就是用来解析Json数据，在其官网http://www.json.org/上有详细讲解，有兴趣的可以去研究
 * @author summer
 *
 */
public class JsonTest {
	
	public static void main(String[] args) {
		//List集合转换成json方法
		List list = new ArrayList();
		list.add("张三");
		list.add(110);
		JSONObject json = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(list);
		System.out.println("List集合转换成json方法--"+jsonArray);
		
		//Map集合转换成json方法
		Map map = new HashMap();
		map.put("name", "jack");
		map.put("age", 27);
		map.put("sex", true);
		JSONObject jsonMap = JSONObject.fromObject(map);
		System.out.println("List集合转换成json方法--"+jsonMap);
		
		// Bean转换成json代码
		User user = new User();
		user.setName("张全党");
		user.setOrderid("2");
		user.setCreatedate(new Date());
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); 
		JSONObject jsonObject = JSONObject.fromObject(user, jsonConfig);
		
		System.out.println("Bean转换成json代码--"+jsonObject);
		
		//beans转为json
		List list1 = new ArrayList(); 
		User user1 = new User();
		user1.setName("张全党");
		user1.setOrderid("2");
		user1.setCreatedate(new Date());
		User user2 = new User();
		user2.setName("张全党1");
		user2.setOrderid("21");
		user2.setCreatedate(new Date());
		list1.add(user1);
		list1.add(user2);
		JSONArray jsonObject1 = JSONArray.fromObject(list1, jsonConfig);
		System.out.println("beans转为json--"+jsonObject1);
		
		//数组转换成json代码
		Boolean[] boolArray = new Boolean[]{true, false, true};	
		JSONArray jsonArray1 = JSONArray.fromObject(boolArray);
		System.out.println("数组转换成json代码--"+jsonArray1);
		
		
		
		//解析json对象list
		String jsonStr = jsonObject1.toString();
		JSONArray jb = JSONArray.fromObject(jsonStr);
		//JSONArray ja = jb.getJSONArray("user");
		
		
		
		List<User> listUser = new ArrayList<User>();
		for(int i = 0,j = jb.size();i<j;i++){
			User uu = new User();
			uu.setName(jb.getJSONObject(i).getString("name"));
			uu.setOrderid(jb.getJSONObject(i).getString("orderid"));
			//uu.setCreatedate(new Date(jb.getJSONObject(i).getString("createdate")));
			uu.setCreatedate(DateUtil.Str2Date(jb.getJSONObject(i).getString("createdate"),null));
			
			listUser.add(uu);
		}
		System.out.println("----解析json对象list---");
		for(int i = 0,j = listUser.size();i<j;i++){
			User uu = listUser.get(i);
			System.out.println(uu.toString());
		}
	}

}
