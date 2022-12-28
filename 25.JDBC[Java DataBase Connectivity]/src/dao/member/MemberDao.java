package dao.member;


import java.sql.*;
import java.util.*;
import java.util.Date;

import dao.address.fourth.*;

/*
 * Dao(Data[DataBase] Access Object)객체
 * 		- member(회원) 데이타를 저장하고있는 테이블에
 *        CRUD(Create,Read,Update,Delete)작업을 할수있는 
 *        단위메쏘드를 가지고있는 클래스
 */
public class MemberDao {

	public MemberDao() {

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
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper04";
		String password = "jdeveloper04";
		
		String insertSQL = "insert into member values('"+member.getM_id()+"','"+member.getM_password()+"',"
														+ "'"+member.getM_name()+"','"+member.getM_address()+"',"
														+ "'"+member.getM_age()+"','"+member.getM_married()+"',"
																+"sysdate" +")";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		
		int rowCount = stmt.executeUpdate(insertSQL);
		System.out.println(">>insert row count : " + rowCount + "행 insert");
		stmt.close();
		con.close();
		
		return rowCount;
	}

	public int update(Member member) throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper04";
		String password = "jdeveloper04";
		
		String updateSQL = "update member set m_password = '"+member.getM_password()+"', m_name = '"+member.getM_name()+"',m_address = '"+member.getM_address()+"',"
							+ "m_age = '"+member.getM_age()+"',m_married = '"+member.getM_married()+"' where m_id = " + member.getM_id();
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		
		int rowCount = stmt.executeUpdate(updateSQL);
		System.out.println(">>update row count : " + rowCount + "행 update");
		stmt.close();
		con.close();
		
		return rowCount;
	}

	public int delete(String m_id) throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper04";
		String password = "jdeveloper04";
		
		String deleteSQL = "delete member where m_id = " + m_id;
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		
		int rowCount = stmt.executeUpdate(deleteSQL);
		System.out.println(">>delete row count : " + rowCount + "행 delete");
		stmt.close();
		con.close();
		
		return rowCount;
	}

	public Member findByPrimaryKey(String m_id) throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper04";
		String password = "jdeveloper04";
		
		String selectSQL = "select m_id,m_password, m_name,m_address, m_age, m_married, m_regdate from member where m_id = " + m_id;
		
		Member findMember = null;
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSQL);
		
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
		stmt.close();
		con.close();
		
		return findMember;
	}

	public List<Member> findAll() throws Exception {
		
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper04";
		String password = "jdeveloper04";
		
		String selectSQL = "select m_id,m_password, m_name,m_address, m_age, m_married, m_regdate from member ";
		
		List<Member> memberList = new ArrayList<Member>();
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSQL);
		
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
			stmt.close();
			con.close();
				
		}
		
		return memberList;
		

	}
}
