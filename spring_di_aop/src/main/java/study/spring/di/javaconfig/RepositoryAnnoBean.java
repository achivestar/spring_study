package study.spring.di.javaconfig;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository("repositoryAnnoBean")
public class RepositoryAnnoBean {
	public RepositoryAnnoBean() {
		System.out.println("RepositoryAnnoBean constructor");
	}
	
	public String getMyName() {
		return "my name is repositoryAnnoBean"; 
	}
	
	@PostConstruct
	public void init() {
		System.out.println("RepositoryAnnoBean init");
	}
}
