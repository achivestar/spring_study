package study.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RefelectionExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class c = Class.forName("study.reflection.RefelectionExample$AnyClass");
			Field[] fields = c.getDeclaredFields();
			
			for (int i=0; i<fields.length; i++) {
				System.out.println(fields[i].getName() + "=>" + fields[i].getType());
			}
			
			Method[] methods = c.getDeclaredMethods();
			for (int i=0; i<methods.length; i++) {
				System.out.println(methods[i].getName() + "=>" + methods[i].getTypeParameters());
			}
			Constructor [] constructors = c.getConstructors();
			System.out.println(constructors[0].getParameterTypes());
			Object obj = constructors[0].newInstance(new RefelectionExample());
			
			((AnyClass)obj).setVar1("test");
			System.out.println(((AnyClass)obj).getVar1());
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

	public class AnyClass {
		private String var1;
		private int var2;
		
		public AnyClass() {
			
		}

		public String getVar1() {
			return var1;
		}

		public void setVar1(String var1) {
			this.var1 = var1;
		}
		
	}
}
