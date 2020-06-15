package javaCodeTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class hashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = "iddd";
		String name ="nameeee";
		// hashmap은 key와 value로 구성되어 있고 key로 value값을 access한다.
		// hashmap은 순서가 없기 때문에 arrayList처럼 접근할 수 없다.
		// 그래서 키값들을 순서있게 만든후(Iterator) 차례대로 접근하면서 value를 출력
		HashMap<String,String> h=new HashMap();
		h.put("id",id);
		h.put("name", name);
		System.out.println(h.get("id"));
		
		Set<String> keys = h.keySet();  
		Iterator<String> it = keys.iterator();
		
		while(it.hasNext()) { 
			String key = it.next();
			String value = h.get(key);
			System.out.println(value);
		}
	}

}
