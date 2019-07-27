package com.study.spring.admin.usermng.dao;

import java.util.List;

import com.study.spring.user.vo.UserVO;

public interface UserMngDAO {
	public List<UserVO> selectUserList();
	public void insertUser(UserVO userVO);
	public UserVO selectUser(String userId);
	public void updateUser(UserVO userVO);
}
