package dao.guest.분리;

import java.sql.*;
import java.util.*;
import java.util.Date;

import dao.common.*;

/*
 * Dao(Data[DataBase] Access Object)객체(클래스)
 *   - guest테이블에 CRUD(Create,Read,Update,Delet)작업을 하는 
 *     단위메쏘드를 가지고있는 객체(클래스)
 */
public class GuestDao {
	private DataSource dataSource;
	
	public GuestDao() throws Exception {
		dataSource = new DataSource();
	}
	
	public int insert(Guest guest) throws Exception {
		

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestDaoSQL.GUEST_INSERT);
	
		Date guest_date = new Date();
		
		pstmt.setString(1, guest.getGuest_name());
		pstmt.setDate(2,new java.sql.Date(guest_date.getTime()));
		pstmt.setString(3, guest.getGuest_email());
		pstmt.setString(4, guest.getGuest_homepage());
		pstmt.setString(5, guest.getGuest_title());
		pstmt.setString(6, guest.getGuest_content());
		
		int rowCount = pstmt.executeUpdate();
		
		System.out.println("insert " + rowCount + "행 추가");
		
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	}
	
	public int update(Guest guest) throws Exception {
	
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestDaoSQL.GUEST_UPDATE);
	
		Date guest_date = new Date();
		
		pstmt.setString(1, guest.getGuest_name());
		pstmt.setDate(2,new java.sql.Date(guest_date.getTime()));
		pstmt.setString(3,guest.getGuest_email());
		pstmt.setString(4, guest.getGuest_homepage());
		pstmt.setString(5, guest.getGuest_title());
		pstmt.setString(6, guest.getGuest_content());
		pstmt.setInt(7, guest.getGuest_no());
		
		int rowCount = pstmt.executeUpdate();
		
		System.out.println("update " + rowCount + "행 변경");
		
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	
	}
	
	public int delete(int guest_no) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestDaoSQL.GUEST_DELETE);
		
		pstmt.setInt(1,guest_no);
		int rowCount = pstmt.executeUpdate();
		
		System.out.println("delete " + rowCount + "행 삭제");
		
		pstmt.close();
		dataSource.close(con);
		
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

		Guest findGuest = null;
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestDaoSQL.GUEST_SELECT_BY_NO);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();

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
		pstmt.close();
		dataSource.close(con);
		return findGuest;
	}
	public List<Guest> findByAllGuest() throws Exception {
		
		
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestDaoSQL.GUEST_SECET_BY_ALL);
		ResultSet rs = pstmt.executeQuery();
		
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
			pstmt.close();
			dataSource.close(con);
		}
	
		return guestList;
	}
	
}
