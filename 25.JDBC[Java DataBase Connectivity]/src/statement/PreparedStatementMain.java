package statement;

import java.sql.*;
import java.util.*;
import java.util.Date;

/*
<<PreparedStatement>>
	- PrepareStatement를 사용하면  sql파싱이 한번만 이루어지므로 성능향상이된다.
	- PrepareStatement를 사용하면  sql을 작성할때 편리하다
	
1. sql문작성
    - ?(파라메타) 를 사용해서 나중에 외부에서 데이타(리터럴)를 받을수있게한다.
      ex> insert into emp(empno,ename,job,manager,hiredate,sal,comm,deptno) values(?,?,?,?,?,?,?,?)	
    - 테이블이름,컬럼이름등은 ? 를 사용해서 외부에서 입력받을수없다.
      ex> select * from ? 
          select ?,? from emp    
2. PreparedStatement 객체생성후 인자로 sql문을 넣어서생성한다
   ex> PreparedStatement pstmt = con.prepareStatement(sql);
3. 생성된 PreparedStatement 객체에 파라메타를 setting(binding) 한다
    - sql 좌측 ? 부터 1,2,3...
   ex> 	pstmt.setInt(1,1234);              
 	   	pstmt.setString(2,"KIM");              
   		pstmt.setString(3,"MANAGER");              
  		pstmt.setInt(4,7839);              
   		pstmt.setDate(5,new Date());              
   		pstmt.setDouble(6,1000.12);              
   		pstmt.setInt(7,0);              
   		pstmt.setInt(8,10);              
 4.  실행
    - 실행시 sql문을 인자로 넣지안는다.
    ex> pstmt.executeUpdate();         
        pstmt.executeQuery();         
*/
public class PreparedStatementMain {

	public static void main(String[] args) throws Exception {
		
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper04";
		String password = "jdeveloper04";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		/*****************************************************************/
		
		String deleteSQL = "delete from emp where empno = ?";
		PreparedStatement pstmt1 = con.prepareStatement(deleteSQL);
		
		/************************9001 delete******************************/
		int empno = 9001;
		pstmt1.setInt(1, empno);
		int rowCount = pstmt1.executeUpdate();
		System.out.println(rowCount + " 행이 delete");
		
		/************************9002 delete******************************/
		empno = 9002;
		pstmt1.setInt(1, empno);
		rowCount = pstmt1.executeUpdate();
		System.out.println(rowCount + " 행이 delete");
		
		/************************9003 delete******************************/
		empno = 9003;
		pstmt1.setInt(1, empno);
		rowCount = pstmt1.executeUpdate();
		System.out.println(rowCount + " 행이 delete");

		/************************9004 delete******************************/
		empno = 9004;
		pstmt1.setInt(1, empno);
		rowCount = pstmt1.executeUpdate();
		System.out.println(rowCount + " 행이 delete");
		
		pstmt1.close();
		
		System.out.println("------[insert]-------");
		
		String insertSQL = "insert into emp values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt2 = con.prepareStatement(insertSQL);
		
		/************************9001 insert******************************/
		empno = 9001;
		String ename = "JUNG";
		String job = "MANAGER";
		int mgr = 7369;
		Date hiredate = new Date();
		double sal = 3000.34;
		int comm = 30;
		int deptno = 40;
		pstmt2.setInt(1, empno);
		pstmt2.setString(2, ename);
		pstmt2.setString(3, job);
		pstmt2.setInt(4, mgr);
		pstmt2.setDate(5, new java.sql.Date(hiredate.getTime()));
		pstmt2.setDouble(6, sal);
		pstmt2.setInt(7, comm);
		pstmt2.setInt(8, deptno);
		
		
		
	}

}
