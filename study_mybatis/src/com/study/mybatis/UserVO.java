package com.study.mybatis;

import java.util.Date;

public class UserVO {
	private String userId;
	private String userNm;
	private String userPw;
	private int userLv;
	private String phone;
	private String email;
	private int tryCnt;
	private String status;
	private Date lastDt;
	private Date updDt;
	private Date regDt;



	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public int getUserLv() {
		return userLv;
	}
	public void setUserLv(int userLv) {
		this.userLv = userLv;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTryCnt() {
		return tryCnt;
	}
	public void setTryCnt(int tryCnt) {
		this.tryCnt = tryCnt;
	}
	public Date getLastDt() {
		return lastDt;
	}
	public void setLastDt(Date lastDt) {
		this.lastDt = lastDt;
	}
	public Date getUpdDt() {
		return updDt;
	}
	public void setUpdDt(Date updDt) {
		this.updDt = updDt;
	}
	public Date getRegDt() {
		return regDt;
	}
	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}


}
