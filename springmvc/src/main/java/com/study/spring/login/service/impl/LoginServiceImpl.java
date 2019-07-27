package com.study.spring.login.service.impl;

import org.springframework.stereotype.Service;

import com.study.spring.common.GlobalConst;
import com.study.spring.login.service.LoginService;
import com.study.spring.user.vo.UserVO;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public UserVO selectUser(String userId, String userPw) throws Exception {
		UserVO userVO = null;
		if (userId.equals(userPw)) {
			userVO = new UserVO();
			userVO.setUserId(userId);
			userVO.setUserNm("테스트");
			userVO.setUserLv(GlobalConst.USER_LEVEL_ADMIN);
		}
		return userVO;
	}

}
