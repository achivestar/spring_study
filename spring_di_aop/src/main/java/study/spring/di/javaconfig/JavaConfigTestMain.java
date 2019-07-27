package study.spring.di.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigTestMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        TestBean app = context.getBean(TestBean.class);
        
        app.processMessage();
        
        // @Repository scan test
        RepositoryAnnoBean bean1 = (RepositoryAnnoBean)context.getBean("repositoryAnnoBean");
        if (bean1 == null) {
        	System.out.println("bean not found");
        } else {
        	System.out.println(bean1.getMyName());
        }
         
        //close the context
        context.close();
	}

}
