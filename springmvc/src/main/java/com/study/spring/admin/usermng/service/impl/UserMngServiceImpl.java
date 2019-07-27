package com.study.spring.admin.usermng.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring.admin.usermng.dao.UserMngDAO;
import com.study.spring.admin.usermng.mapper.UserMngMapper;
import com.study.spring.admin.usermng.service.UserMngService;
import com.study.spring.user.vo.UserVO;

@Service("userMngService")
public class UserMngServiceImpl implements UserMngService {
	@Autowired
	private UserMngDAO userMngDAO;

	@Autowired
	private UserMngMapper userMapper;

	@Override
	public List<UserVO> selectUserList() throws Exception {
		return userMngDAO.selectUserList();
	}

	@Override
	public void insertUser(UserVO userVO) throws Exception {
		userMngDAO.insertUser(userVO);
	}

	@Override
	public UserVO selectUser(String userId) {
		return userMngDAO.selectUser(userId);
	}

	/** mapper interface 방식 사용 **/

	@Override
	public void updateUser(UserVO userVO) throws Exception {
		userMapper.updateUser(userVO);

		// transaction test
		boolean testTransaction = true;
		if (testTransaction) {
			throw new Exception("if exception throw then rollback test");
		}
	}

}
