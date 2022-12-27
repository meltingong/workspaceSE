package Basic;

import java.sql.*;

public class AddressTableSelectAllByPrimaryKeyMain {

	public static void main(String[] args) throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		String selectSQL = "select no,name,phone,address from address";
		
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
		//if문이 있을 경우 1개의 테이블이 출력되지 않음 이때, 모두 출력 하고 싶다면 do-while문 사용
		rs.close();
		stmt.close();
		con.close();

	}

}
