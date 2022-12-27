package dao.address.third;

import java.sql.*;

/*
 * Dao(Data Access Object) 객체(클래스)
 * 		- address테이블에 CRUD(Create,Read,Update,Delete) 작업을 하는 
 * 		  단위메소드를 가지고 있는 클래스
 * 		- MemberService객체 의 요청(메쏘드호출)을 받아서 Data Access(File, DB)에 관련된 단위기능(CRUD)을
	   	  수행하는 객체
 */
public class AddressDao3 {
	public AddressDao3() {
	
	}
	
	public void insert(Address newAddress) throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		String insertSQL = "insert into address values(address_no_seq.nextval,"
									+ "'"+newAddress.getName()+"',"
									+ "'"+newAddress.getPhone()+"',"
									+ "'"+newAddress.getAddress()+"')";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();

		int rowCount = stmt.executeUpdate(insertSQL);
		
		System.out.println(">>insert row count : " + rowCount + "행 insert");
		stmt.close();
		con.close();
	}
	
	
	public void update(Address updateAddress) throws Exception{
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		String updateSQL = "update address set name='"
							+updateAddress.getName()
							+"',phone='"+updateAddress.getPhone()
							+"',address='"+updateAddress.getAddress()
							+"' where no = "+ updateAddress.getNo();
		
		Class.forName(driverClass); //오라클 드라이버만 로딩 안해도 됨
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(updateSQL);
		System.out.println(" >> " + rowCount + "행 Update");
		stmt.close();
		con.close();
	}
	
	public void delete(int no) throws Exception{
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		String deleteSQL = "delete address where no =" +no;
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSQL);
		System.out.println(">> " + rowCount + "행 delete");
		stmt.close();
		con.close();
	}
	
	public void findByPrimaryKey(int no) throws Exception{
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		String selectSQL = "select no,name,phone,address from address where no =" + no;
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(selectSQL);
		if(rs.next()) {
			
			int n = rs.getInt("no");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			System.out.println(n + "\t" + name + "\t" + phone + "\t" + address);
		}else {
			System.out.println("조건을 만족하는 주소록이 존재하지 않습니다.");
		}
		
		rs.close();
		stmt.close();
		con.close();

	}
	
	public void findAll() throws Exception{
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		String selectSQL = "select no,name,phone,address from address";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
	
		ResultSet rs = stmt.executeQuery(selectSQL);
		if(rs.next()) {
			 do{
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				System.out.println(no + "\t" + name + "\t" + phone + "\t" + address);
			} while(rs.next());
		}else {
			System.out.println("조건을 만족하는 주소록이 없습니다");
		}
		
		stmt.close();
		con.close();

	}
	
	
	
}
