package study.spring.di.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigTestMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        XmlTestBean app1 = ctx.getBean(XmlTestBean.class);
         
        app1.processMessage();
        app1.setVal1("val1 changed");
        
        XmlTestBean app2 = (XmlTestBean)ctx.getBean("myXmlTestApplication");
        app1.processMessage();
	}

}
