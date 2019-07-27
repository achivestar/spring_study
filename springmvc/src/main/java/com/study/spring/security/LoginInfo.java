package com.study.spring.security;

public class LoginInfo {
	private String id;
	private String name;
	private int level;
	private String levelNm;
	
	public boolean isValidId() {
		return (id != null && !id.trim().isEmpty());
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getLevelNm() {
		return levelNm;
	}
	public void setLevelNm(String levelNm) {
		this.levelNm = levelNm;
	}
	
	
}
