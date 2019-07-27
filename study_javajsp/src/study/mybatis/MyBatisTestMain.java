package study.mybatis;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

/**
 * mybatis를 사용하여 사용자 정보를 조회하는 예제로
 * test1이라는 아이디의 사용자가 있으면 삭제 후 다시 등록 그리고 조회한다.
 * study데이터베이스, USER 테이블 필요
 * @author Park
 *
 */
public class MyBatisTestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		try {


			// test1 아이디 사용자 조회
			Map userData = (HashMap)session.selectOne("study.mybatis.UserMapper.selectUser", "test1");
			System.out.println("USER : " + userData);

			// 사용자 삭제 후 재등록
			if (userData != null) {
				session.delete("study.mybatis.UserMapper.deleteUser", "test1");
				System.out.println("delete " + userData.get("USER_ID"));
			}
			Map param = new HashMap();
			param.put("userId", "test1");
			param.put("userNm", "테스트1");
			param.put("userPw", "3333");
			param.put("phone", "");
			param.put("email", "");
			param.put("userLv", 0);
			param.put("status", "00");
			int affected = session.insert("study.mybatis.UserMapper.insertUser", param);
			System.out.println("insert affected : " +affected);

			// rollback 테스트 (innodb로 변경하여 테스트할 것)
			//if (1==1) throw new Exception("throw");

			// test1 아이디 사용자 재조회
			userData = (HashMap)session.selectOne("study.mybatis.UserMapper.selectUser", "test1");
			System.out.println("USER : " + userData);

			session.commit();	// 커밋
		} catch (Exception ex) {
			session.rollback(); // 롤백
		} finally {
			session.close();
		}

	}

}
