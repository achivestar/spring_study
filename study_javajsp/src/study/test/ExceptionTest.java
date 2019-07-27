package study.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExceptionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			checkLogin(null);
			
			
		} catch (InvalidLoginException e) {
			e.printStackTrace();
		}
	
		String test = "test3333333333";
		
		if ("".equals(test)) {
			
		}
		if (test.isEmpty()) {
			
		}
		test.substring(3);
		test.substring(3,6);
		
		Map para = new HashMap();
		para.put("key1", "value");
		
		// Generics
		String val = (String)para.get("key1");
		
		Map<String, String> param2 = new HashMap<String, String>();
		String val2 = param2.get("test");
		
		
		Map param3 = new HashMap();
		param3.put("intkey1", 3);
		param3.put("stringkey1", "string");
		
		Integer val4 = (Integer)param3.get("stringkey1");
		
		
		List list = new ArrayList();
		list.add("test1");
		String str1 = (String)list.get(0);
		
		List<String> list2 = new ArrayList<String>();
		String str2 = list2.get(0);
		
		
	}

	
	private static void checkLogin(String loginId) throws InvalidLoginException {
		if (loginId == null || "".equals(loginId)) {
			throw new InvalidLoginException("로그인안됐음");
		}
	}
}
