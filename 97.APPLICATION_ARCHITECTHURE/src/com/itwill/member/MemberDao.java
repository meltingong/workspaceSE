package com.itwill.member;

import java.sql.*;
import java.util.*;
import java.util.Date;

import com.itwill.common.*;

/*
 * Dao(Data[DataBase] Access Object)객체
 * 		- member(회원) 데이타를 저장하고있는 테이블에
 *        CRUD(Create,Read,Update,Delete)작업을 할수있는 
 *        단위메쏘드를 가지고있는 클래스
 */
public class MemberDao {
	private DataSource dataSource;
	
	public MemberDao() throws Exception {
		dataSource = new DataSource();
	}

	/*
			이름         널?       유형            
		---------- -------- ------------- 
		M_ID       NOT NULL VARCHAR2(20)  
		M_PASSWORD NOT NULL VARCHAR2(20)  
		M_NAME     NOT NULL VARCHAR2(50)  
		M_ADDRESS           VARCHAR2(100) 
		M_AGE               NUMBER(3)     
		M_MARRIED           CHAR(1)       
		M_REGDATE           DATE          

	 */
	
	public int insert(Member member) throws Exception {
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberDaoSQL.MEMBER_INSERT);
		pstmt.setString(1, member.getM_id());
		pstmt.setString(2, member.getM_password());
		pstmt.setString(3, member.getM_name());
		pstmt.setString(4, member.getM_address());
		pstmt.setInt(5, member.getM_age());
		String m_married = String.valueOf(member.getM_married());
		pstmt.setString(6, m_married);
		
		int rowCount = pstmt.executeUpdate();
		System.out.println(">>insert row count : " + rowCount + "행 insert");
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	}

	public int update(Member member) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberDaoSQL.MEMBER_UPDATE);
		pstmt.setString(1, member.getM_id());
		pstmt.setString(2, member.getM_password());
		pstmt.setString(3, member.getM_name());
		pstmt.setString(4, member.getM_address());
		pstmt.setInt(5, member.getM_age());
		String m_married = String.valueOf(member.getM_married());
		pstmt.setString(6, m_married);
		
		int rowCount = pstmt.executeUpdate();
		System.out.println(">>update row count : " + rowCount + "행 update");
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	}

	public int delete(String m_id) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberDaoSQL.MEMBER_DELETE);
		pstmt.setString(1, "m_id");
		int rowCount = pstmt.executeUpdate();
		System.out.println(">>delete row count : " + rowCount + "행 delete");
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	}

	public Member findByPrimaryKey(String m_id) throws Exception {

		Member findMember = null;
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberDaoSQL.MEMBER_SELECT_BY_ID);
		pstmt.setString(1, "m_id");
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			
			String id = rs.getString("m_id");
			String m_password = rs.getString("m_password");
			String m_name = rs.getString("m_name");
			String m_address = rs.getString("m_address");
			int m_age = rs.getInt("m_age");
			String m_married = rs.getString("m_married");
			char married = m_married.charAt(0);
			Date m_regdate = rs.getDate("m_regdate");
			
			findMember = new Member(id,m_password,m_name,m_address,m_age,married,m_regdate);
		}
		rs.close();
		pstmt.close();
		dataSource.close(con);
		
		return findMember;
	}

	public List<Member> findAll() throws Exception {
	
		List<Member> memberList = new ArrayList<Member>();
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberDaoSQL.MEMBER_SELECT_ALL);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			do {
				String id = rs.getString("m_id");
				String m_password = rs.getString("m_password");
				String m_name = rs.getString("m_name");
				String m_address = rs.getString("m_address");
				int m_age = rs.getInt("m_age");
				String m_married = rs.getString("m_married");
				char married = m_married.charAt(0);
				Date m_regdate = rs.getDate("m_regdate");
				
				Member findMember = new Member(id,m_password,m_name,m_address,m_age,married,m_regdate);
				memberList.add(findMember);
				
			}while(rs.next());
			
			rs.close();
			pstmt.close();
			dataSource.close(con);
				
		}
		
		return memberList;
		

	}
}
