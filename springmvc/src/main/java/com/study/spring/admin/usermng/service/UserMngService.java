package com.study.spring.admin.usermng.service;

import java.util.List;

import com.study.spring.user.vo.UserVO;

public interface UserMngService {
	public List<UserVO> selectUserList() throws Exception;
	public void insertUser(UserVO userVO) throws Exception;
	public UserVO selectUser(String userId);
	public void updateUser(UserVO userVO) throws Exception;
}
