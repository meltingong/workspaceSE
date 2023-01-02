package dao.user;

import java.util.List;
/*
 사용자관리에서 데이타베이스와의 작업을 전담하는 클래스
 USERINFO 테이블에 사용자를 추가,삭제,검색,수정등의 작업을한다.
 */
public class UserDao {
	/*****DataSource객체멤버필드로선언 [Connection을 반환해주는객체] */
	
	public UserDao() throws Exception {
		/******DataSource 객체생성 초기화*****/
		
	}

	/*
	 * 사용자관리테이블에 새로운사용자생성
	 */
	public int insert() throws Exception {
		
		return 0;
	}

	/*
	 * 기존의 사용자정보를 수정
	 */
	public int update() throws Exception {
		return 0;
	}

	/*
	 * 사용자아이디에해당하는 사용자를 삭제
	 */
	public int delete() throws Exception {
		
		return 0;
	}

	/*
	 * 사용자아이디에해당하는 정보를 데이타베이스에서 찾아서 User 도메인클래스에 저장하여 반환
	 */
	public User findByPrimaryKey(String userId) throws Exception {
		return null;
	}

	/*
	 * 모든사용자 정보를 데이타베이스에서 찾아서 List<User> 콜렉션 에 저장하여 반환
	 */
	public List<User> findAll() throws Exception {
		
		return null;
	}

}
