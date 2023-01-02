package dao.user;

import java.sql.*;
import java.util.*;

import dao.common.*;
/*
 사용자관리에서 데이타베이스와의 작업을 전담하는 클래스
 USERINFO 테이블에 사용자를 추가,삭제,검색,수정등의 작업을한다.
 */
public class UserDao {
	/*****DataSource객체멤버필드로선언 [Connection을 반환해주는객체] */
	private DataSource  dataSource;
	public UserDao() throws Exception {
		/******DataSource 객체생성 초기화*****/
		dataSource = new DataSource();
	}

	/*
	 * 사용자관리테이블에 새로운사용자생성
	 */
	public int insert(User user) throws Exception {
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserSQL.USER_INSERT);
		pstmt.setString(1, user.getUserId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getEmail());
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}

	/*
	 * 기존의 사용자정보를 수정
	 */
	public int update(User user) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserSQL.USER_UPDATE);
		pstmt.setString(1, user.getPassword());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getEmail());
		pstmt.setString(4, user.getUserId());
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}

	/*
	 * 사용자아이디에해당하는 사용자를 삭제
	 */
	public int delete(String userId) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserSQL.USER_DELETE);
	
		pstmt.setString(1, userId);
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}

	/*
	 * 사용자아이디에해당하는 정보를 데이타베이스에서 찾아서 User 도메인클래스에 저장하여 반환
	 */
	public User findByPrimaryKey(String userId) throws Exception {
		
		User findUser = null;
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserSQL.USER_SELECT_BY_ID);
	
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			findUser = new User(rs.getString("userId"),
								rs.getString("password"),
								rs.getString("name"),
								rs.getString("email"));
			break;
		}
		return findUser;
	}

	/*
	 * 모든사용자 정보를 데이타베이스에서 찾아서 List<User> 콜렉션 에 저장하여 반환
	 */
	public List<User> findAll() throws Exception {
		List<User> userList = new ArrayList<User>();
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserSQL.USER_SELECT_ALL);
	
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			userList.add(new User(	rs.getString("userId"),
									rs.getString("password"),
									rs.getString("name"),
									rs.getString("email")));
		}
		return userList;
	}

}
