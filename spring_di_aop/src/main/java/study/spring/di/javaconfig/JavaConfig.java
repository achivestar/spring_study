package study.spring.di.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="study.spring.di.javaconfig")
public class JavaConfig {
	@Bean
	TestBean getMyJavaConfigTestApplication() {
		return new TestBean("hi", "ho~");
	}
}
