package study.spring.aop;

public class AspectTargetInterfaceImplBean implements AspectTestInterface {

	@Override
	public void interfaceTest() {
		System.out.println("interfaceTest executed");
	}
}
