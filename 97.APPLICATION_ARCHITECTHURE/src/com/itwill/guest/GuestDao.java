package com.itwill.guest;

import java.sql.*;
import java.util.*;
import java.util.Date;

/*
 * Dao(Data[DataBase] Access Object)객체(클래스)
 *   - guest테이블에 CRUD(Create,Read,Update,Delet)작업을 하는 
 *     단위메쏘드를 가지고있는 객체(클래스)
 */
public class GuestDao {
	
	public int insert(Guest guest) throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper04";
		String password = "jdeveloper04";
		
		String insertSQL = "insert into guest values(guest_guest_no_seq.nextval,?,?,?,?,?,?)";
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt = con.prepareStatement(insertSQL);
		
		String guest_name = guest.getGuest_name();
		Date guest_date = new Date();
		String guest_email = guest.getGuest_email();
		String guest_homepage = guest.getGuest_homepage();
		String guest_title = guest.getGuest_title();
		String guest_content = guest.getGuest_content();
		
		pstmt.setString(1, guest_name);
		pstmt.setDate(2,new java.sql.Date(guest_date.getTime()));
		pstmt.setString(3, guest_email);
		pstmt.setString(4, guest_homepage);
		pstmt.setString(5, guest_title);
		pstmt.setString(6, guest_content);
		
		int rowCount = pstmt.executeUpdate();
		
		System.out.println("insert " + rowCount + "행 추가");
		
		pstmt.close();
		con.close();
		
		return rowCount;
	}
	
	public int update(Guest guest) throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper04";
		String password = "jdeveloper04";
		
		String updateSQL = "update guest set guest_name = ?, guest_date = ?, guest_email = ?, guest_homepage = ?, guest_title = ?, guest_content = ? where guest_no = ? ";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt = con.prepareStatement(updateSQL);
		int guest_no = guest.getGuest_no();
		String guest_name = guest.getGuest_name();
		Date guest_date = new Date();
		String guest_email = guest.getGuest_email();
		String guest_homepage = guest.getGuest_homepage();
		String guest_title = guest.getGuest_title();
		String guest_content = guest.getGuest_content();
		
		pstmt.setString(1, guest_name);
		pstmt.setDate(2,new java.sql.Date(guest_date.getTime()));
		pstmt.setString(3, guest_email);
		pstmt.setString(4, guest_homepage);
		pstmt.setString(5, guest_title);
		pstmt.setString(6, guest_content);
		pstmt.setInt(7, guest_no);
		
		int rowCount = pstmt.executeUpdate();
		
		System.out.println("update " + rowCount + "행 변경");
		
		pstmt.close();
		con.close();
		
		return rowCount;
	
	}
	
	public int delete(int guest_no) throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper04";
		String password = "jdeveloper04";
		
		String deleteSQL = "delete guest where guest_no = ? ";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt = con.prepareStatement(deleteSQL);
		
		pstmt.setInt(1,guest_no);
		int rowCount = pstmt.executeUpdate();
		
		System.out.println("delete " + rowCount + "행 삭제");
		
		pstmt.close();
		con.close();
		
		return rowCount;
	}
	/*
	이름             널?       유형             
	-------------- -------- -------------- 
	GUEST_NO       NOT NULL NUMBER(10)     
	GUEST_NAME              VARCHAR2(50)   
	GUEST_DATE              DATE           
	GUEST_EMAIL             VARCHAR2(50)   
	GUEST_HOMEPAGE          VARCHAR2(50)   
	GUEST_TITLE             VARCHAR2(100)  
	GUEST_CONTENT           VARCHAR2(4000) 
	*/
	
	public Guest findByGuest(int no) throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper04";
		String password = "jdeveloper04";
		
		String selectSQL = "select guest_no,guest_name,guest_date,guest_email,guest_homepage,guest_title,guest_content from guest where guest_no = " +no;
		
		Guest findGuest = null;
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSQL);

		if(rs.next()) {
			
			int guest_no = rs.getInt("guest_no");
			String guest_name = rs.getString("guest_name");
			Date guest_date = rs.getDate("guest_date");
			String guest_email = rs.getString("guest_email");
			String guest_homepage = rs.getString("guest_homepage");
			String guest_title = rs.getString("guest_title");
			String guest_content = rs.getString("guest_content");

			findGuest = new Guest(guest_no,guest_name,guest_date,guest_email,guest_homepage,guest_title,guest_content);

		}
		rs.close();
		stmt.close();
		con.close();
		return findGuest;
	}
	public List<Guest> findByAllGuest() throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper04";
		String password = "jdeveloper04";
		
		String selectSQL = "select guest_no,guest_name,guest_date,guest_email,guest_homepage,guest_title,guest_content from guest";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSQL);
		
		List<Guest> guestList = new ArrayList<Guest>();
		
		if(rs.next()) {
			do {
				int guest_no = rs.getInt("guest_no");
				String guest_name = rs.getString("guest_name");
				Date guest_date = rs.getDate("guest_date");
				String guest_email = rs.getString("guest_email");
				String guest_homepage = rs.getString("guest_homepage");
				String guest_title = rs.getString("guest_title");
				String guest_content = rs.getString("guest_content");

				guestList.add(new Guest(guest_no,guest_name,guest_date,guest_email,guest_homepage,guest_title,guest_content));
				
			}while(rs.next());
			
			rs.close();
			stmt.close();
			con.close();
		}
	
		return guestList;
	}
	
}
