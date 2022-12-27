package Basic;

import java.sql.*;

public class JDBCFlowMain {

	public static void main(String[] args) throws Exception {
		/************************데이터베이스 접속정보*****************************/
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		String selectSql = "select deptno,dname,loc from dept order by deptno";
		
		/*
		 * 1. Driver class loading
		 * 		A. Driver Class객체생성
		 * 		B. DriverManager 객체등록
		 */
		Class.forName(driverClass);
		System.out.println("1.Driver class loading");
		
		/*
		 * 2. Connection 객체생성
		 * 		- DB Server와 연결객체
		 */
		Connection con = DriverManager.getConnection(url,user,password);
		System.out.println("2.Connection 객체생성 : " + con);
		
		/*
		 * 3. Satement객체생성
		 * 		- SQL전송 객체 생성
		 */
		Statement stmt = con.createStatement();
		System.out.println("3.Statement 객체생성 : " + stmt);
		
		/*
		 * 4. SQL문 전송(Select)
		 * 5. ResultSet 객체 얻기(select)
		 
			---------------------------------
			DEPTNO    DNAME        	LOC
			---------------------------------
	(cursor) ▶ BEFORE FIRST 영역 (BOF - Begin of files)
			10	 	ACCOUNTING		NEW YORK
			20		RESEARCH		DALLAS
			30		SALES			CHICAGO
			40		OPERATIONS		BOSTON
			AFTER LAST  영역   (EOF - End of files)
		 
		 */
		
		ResultSet rs = stmt.executeQuery(selectSql);
		System.out.println("4,5. ResultSet 객체얻기(select문 실행결과) : " + rs);
		System.out.println("--------------------------------");
		System.out.println("DEPNO	DNAME		LOC");
		System.out.println("--------------------------------");
		while(rs.next()) {
			int deptno = rs.getInt("deptno");
			String dname = rs.getString("dname");
			String loc = rs.getString("loc");
			System.out.println(deptno + "\t" + dname + "\t" + loc);
		}
		
		/*
		 * 6. 연결객체 해지(resource 해지) close
		 */
		
		rs.close();
		stmt.close();
		con.close();
		System.out.println("6. 연결객체 닫기");
		
	}

}
