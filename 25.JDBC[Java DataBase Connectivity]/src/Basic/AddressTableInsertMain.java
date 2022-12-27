package Basic;

import java.sql.*;

public class AddressTableInsertMain {

	public static void main(String[] args) throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		String insertSQL = "insert into address values(address_no_seq.nextval,'집가자','123-4568','경기도 시흥시')";
		
		/*
		 1.Driver class loading
	     2.Connection 객체생성
		 3.Statement객체생성
		 4.SQL문전송(insert)
		 5.SQL문전송(insert)결과 영향받은행의수 반환
		 6.연결객체해지(resource해지) close
		 */
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();

		int rowCount = stmt.executeUpdate(insertSQL);
		/*
		 * executeUpdate 
		 *  >>  select 처럼 반환하는 게 아닌 경우 위와 같은 메소드를 호출함 (DML 및 DDL -- insert , update, delete 및 drop , create (DDL 잘 사용x))
		 *  	select는 executeQuery 호출
		 */
		System.out.println(">>insert row count : " + rowCount + "행 insert");
		stmt.close();
		con.close();
		
		
		
		
		
	}

}
