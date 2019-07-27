package com.study.spring.admin.usermng.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.spring.admin.usermng.dao.UserMngDAO;
import com.study.spring.user.vo.UserVO;

@Repository("userMngDAO")
public class UserMngDAOImpl implements UserMngDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserMngDAOImpl.class);

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<UserVO> selectUserList() {
		return sqlSession.selectList("com.study.spring.admin.usermng.mapper.UserMngMapper.selectUserList");
	}

	@Override
	public void insertUser(UserVO userVO) {
		sqlSession.insert("com.study.spring.admin.usermng.mapper.UserMngMapper.inserUser", userVO);
	}

	@Override
	public UserVO selectUser(String userId) {
		return sqlSession.selectOne("com.study.spring.admin.usermng.mapper.UserMngMapper.selectUser", userId);
	}

	@Override
	public void updateUser(UserVO userVO) {
		sqlSession.update("com.study.spring.admin.usermng.mapper.UserMngMapper.updateUser", userVO);
	}

}
