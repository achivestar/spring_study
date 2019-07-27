package com.study.spring.login.service;

import com.study.spring.user.vo.UserVO;

public interface LoginService {
	UserVO selectUser(String userId, String userPw) throws Exception;
}
