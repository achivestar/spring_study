package study.spring.aop;

public class AspectTargetBean {
	public void test() throws Exception {
		System.out.println("AspectTargetBean.test() executed");
	}
	
	public String target1() throws Exception {
		System.out.println("AspectTargetBean.target1() executed");
		return "target1";
	}
	
	public String target2(String arg1) throws Exception {
		System.out.println("AspectTargetBean.target2() executed");
		return arg1;
	}

}
