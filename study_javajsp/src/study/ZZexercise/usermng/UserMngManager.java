package study.ZZexercise.usermng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserMngManager extends BaseManager {
	private static UserMngManager instance;

	private UserMngManager() {
	}

	public static UserMngManager getInstance() {
		if (instance == null) {
			instance = new UserMngManager();
		}

		return instance;
	}

	public List<UserVO> getUserList(String searchCondition, String searchKey) throws DataAccessException {
		List<UserVO> list = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("SELECT USER_ID, USER_NM, USER_PW, USER_LV, PHONE, EMAIL, TRY_CNT, STATUS, LAST_DT, UPD_DT, REG_DT FROM USER WHERE 1=1 ");
			if (valid(searchCondition) && valid(searchKey)) {
				if ("ID".equals(searchCondition)) {
					sql.append("AND USER_ID = ?");
				} else if ("NM".equals(searchCondition)) {
					sql.append("AND USER_NM LIKE '%'||?||'%'");
				}
			}

			stmt = conn.prepareStatement(sql.toString());
			if (valid(searchCondition) && valid(searchKey)) {
				if ("ID".equals(searchCondition) || "NM".equals(searchCondition)) {
					stmt.setString(1, searchKey);
				}
			}

			rs = stmt.executeQuery();

			if (rs != null) {
				list = new ArrayList<UserVO>();
				UserVO user = null;
				while(rs.next()) {
					user = new UserVO();
					user.setUserId(rs.getString("USER_ID"));
					user.setUserNm(rs.getString("USER_NM"));
					user.setUserPw(rs.getString("USER_PW"));
					user.setPhone(rs.getString("PHONE"));
					user.setEmail(rs.getString("EMAIL"));
					user.setUserLv(rs.getInt("USER_LV"));
					user.setTryCnt(rs.getInt("TRY_CNT"));
					user.setStatus(rs.getString("STATUS"));
					user.setLastDt(rs.getDate("LAST_DT"));
					user.setUpdDt(rs.getDate("UPD_DT"));
					user.setRegDt(rs.getDate("REG_DT"));
					list.add(user);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
			closeConnection(conn);
		}

		return list;
	}

	public boolean insertUser(UserVO userVO) throws DataAccessException {
		int affected = 0;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO USER (USER_ID, USER_NM, USER_PW, USER_LV, PHONE, EMAIL, TRY_CNT, STATUS, LAST_DT, UPD_DT, REG_DT) ")
				.append(" VALUES (?, ?, ?, ?, ?, ?, 0, ?, NULL, NOW(), NOW()) ");

			stmt = conn.prepareStatement(sql.toString());

			int idx = 1;
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(idx++, userVO.getUserId());
			stmt.setString(idx++, userVO.getUserNm());
			stmt.setString(idx++, userVO.getUserPw());
			stmt.setInt(idx++, userVO.getUserLv());
			stmt.setString(idx++, userVO.getPhone());
			stmt.setString(idx++, userVO.getEmail());
			stmt.setString(idx++, userVO.getStatus());

			affected = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		} finally {
			closeStatement(stmt);
			closeConnection(conn);
		}

		return (affected>0);
	}
}
