package com.study.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyBatisSampleMain {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Logger logger = LogManager.getLogger(MyBatisSampleMain.class);

		String resource = "com/study/mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();

		String searchCondition = "ID";
		String searchKeyword = "test1";
		try {

			Map param = new HashMap();
			param.put("searchCondition", searchCondition);
			param.put("searchKeyword", searchKeyword);
			List<UserVO> list = session.selectList("com.study.mybatis.UserMngMapper.selectUserList", param);

			if (list != null) {
				UserVO userVO = null;
				for (int i = 0; i < list.size(); i++) {
					userVO = list.get(i);
					logger.info("userId : " + userVO.getUserId());
					logger.info("userNm : " + userVO.getUserNm());
					logger.debug("debug log");
					logger.error("error log");
					logger.warn("warn log");
				}
			}

		} finally {
			session.close();
		}
	}

}
