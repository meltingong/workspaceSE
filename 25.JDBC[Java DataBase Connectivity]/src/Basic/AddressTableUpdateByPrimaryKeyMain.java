package Basic;

import java.sql.*;

public class AddressTableUpdateByPrimaryKeyMain {

	public static void main(String[] args) throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		String updateSQL = "update address set name='김경호',phone='899-9999',address='제주시 애월읍' where no = 1";
		
		Class.forName(driverClass); //오라클 드라이버만 로딩 안해도 됨
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(updateSQL);
		System.out.println(" >> " + rowCount + "행 Update");
		stmt.close();
		con.close();
		
		
		
		
		
		
		
		
		
	}

}
