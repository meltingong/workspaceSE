package dao.address;

import java.sql.*;

/*
	데이타베이스 설정정보를 사용해서 
	Connection객체를 생성하고, 해지하는 역할을 하는 클래스
	(Dao객체들이 사용하는 객체) 
 */
public class DataSource {
	
	private String driverClass = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "scott";
	private String password = "tiger";
	
	/*
	 * Connection 객체를 생성해서 반환하는 메소드 
	 */
	
	public Connection getConnection() throws Exception {
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		return con;
	}
	
	/*
	 *  Connection 객체를 닫는 메소드
	 */
	
	public void close(Connection con) throws Exception {
		con.close();
	}
	
	
	
	
	
}
