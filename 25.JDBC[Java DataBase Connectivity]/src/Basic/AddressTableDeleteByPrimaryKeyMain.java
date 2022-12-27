package Basic;

import java.sql.*;

public class AddressTableDeleteByPrimaryKeyMain {

	public static void main(String[] args) throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		String deleteSQL = "delete address where no = 11";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSQL);
		System.out.println(">> " + rowCount + "행 delete");
		stmt.close();
		con.close();
		
		
	}

}
