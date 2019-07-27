package study.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigAopTestMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
		AspectTargetBean bean = ctx.getBean(AspectTargetBean.class);
        bean.test();
        System.out.println("----------------------------------");
        bean.target1();
        System.out.println("----------------------------------");
        bean.target2("test");
        System.out.println("=================================");
        
        
        AspectTestInterface bean2 = (AspectTestInterface)ctx.getBean("aspectTargetInterfaceImplBean");
        bean2.interfaceTest();
        System.out.println("=================================");
	}

}
