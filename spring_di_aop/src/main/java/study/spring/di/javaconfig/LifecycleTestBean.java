package study.spring.di.javaconfig;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component("lifecycleTestBean")
public class LifecycleTestBean implements InitializingBean, BeanNameAware {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("LifecycleTestBean.afterPropertiesSet()");
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println("LifecycleTestBean.setBeanName " + arg0);
	}


}
