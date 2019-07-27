package com.study.spring.admin.usermng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.spring.user.vo.UserVO;

@Mapper
public interface UserMngMapper {
	public List<UserVO> selectUserList();
	public void insertUser(UserVO userVO);
	public void updateUser(UserVO userVO);
}
