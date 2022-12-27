package Basic;

import java.sql.*;

public class AddressTableSelectByPrimaryKeyMain {

	public static void main(String[] args) throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		String selectSQL = "select no,name,phone,address from address where no = 3";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		/*
		 << statement >>
		 ResultSet executeQuery(String sql) throws SQLException
			Executes the given SQL statement, which returns a single ResultSet object.
		
		 Parameters:
		 	sql - an SQL statement to be sent to the database, typically a static SQL SELECT statement
		 Returns:
			a ResultSet object that contains the data produced by the given query; never null
		 */
		ResultSet rs = stmt.executeQuery(selectSQL);
		if(rs.next()) {
			/* --------------------------------
			 * DB타입 		| 자바타입
			 * --------------------------------
			 * number		| int,double(float)
			 * varchar2,char| String
			 * Date			| Date
			 * --------------------------------
			 */
			int no = rs.getInt("no");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			System.out.println(no + "\t" + name + "\t" + phone + "\t" + address);
		}else {
			System.out.println("조건을 만족하는 주소록이 존재하지 않습니다.");
		}
		
		rs.close();
		stmt.close();
		con.close();

	}

}
