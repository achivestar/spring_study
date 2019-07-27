package study.spring.di.xmlconfig;

public class XmlTestBean {
	private String val1;
	private String val2;
	
	XmlTestBean(String val1, String val2) {
		this.val1 = val1;
		this.val2 = val2;
	}
	
	public void processMessage() {
		System.out.println("val1 => " + val1 + ", val2 => " + val2);
	}

	public String getVal1() {
		return val1;
	}

	public void setVal1(String val1) {
		this.val1 = val1;
	}

	public String getVal2() {
		return val2;
	}

	public void setVal2(String val2) {
		this.val2 = val2;
	}
	
	
}
