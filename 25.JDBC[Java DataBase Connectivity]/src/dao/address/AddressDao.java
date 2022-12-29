package dao.address;

import java.sql.*;
import java.util.*;

/*
 * Dao(Data Access Object) 객체(클래스)
 * 		- address테이블에 CRUD(Create,Read,Update,Delete) 작업을 하는 
 * 		  단위메소드를 가지고 있는 클래스
 * 		- MemberService객체 의 요청(메쏘드호출)을 받아서 Data Access(File, DB)에 관련된 단위기능(CRUD)을
	   	  수행하는 객체
 */
public class AddressDao {
	
	/*
	 * Connection을 생성하고 해지하는 DataSource객체를 멤버필드로 가짐
	 */
	
	private DataSource dataSource;
	
	public AddressDao() {
		/*
		 * dataSource멤버필드 초기화
		 */
		this.dataSource = new DataSource();
	}

	public int insert(Address newAddress) throws Exception {
		
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_INSERT);
		pstmt.setString(1, newAddress.getName());
		pstmt.setString(2, newAddress.getPhone());
		pstmt.setString(3, newAddress.getAddress());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	}

	public int update(Address updateAddress) throws Exception{	
		
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_UPDATE);
		
		pstmt.setString(1, updateAddress.getName());
		pstmt.setString(2, updateAddress.getPhone());
		pstmt.setString(3, updateAddress.getAddress());
		pstmt.setInt(4, updateAddress.getNo());
		
		int rowCount = pstmt.executeUpdate();
		//System.out.println(" >> " + rowCount + "행 Update");
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
	public int delete(int no) throws Exception{
		
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_DELETE);
		pstmt.setInt(1, no);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
	
		return rowCount;
	}
	
	public Address findByPrimaryKey(int no) throws Exception{
		
		
		
		Address findAddress = null;
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_SELECT_BY_NO);
		
		pstmt.setInt(1, no);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			int n = rs.getInt("no");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			findAddress = new Address(n, name, phone, address);
		}
		rs.close();
		pstmt.close();
		dataSource.close(con);
		
		return findAddress;
	}
	
	public List<Address> findAll() throws Exception{
		
		
		
		List<Address> addressList = new ArrayList<Address>();
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_SELECT_ALL);
	
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			 do{
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String addr = rs.getString("address");
				Address address = new Address(no, name, phone, addr);
				addressList.add(address);
				
			 } while(rs.next());
		}
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return addressList;
	}
	
	
	
}
