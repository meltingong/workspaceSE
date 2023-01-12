package web;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressListServlet {
	
	public void service(PrintWriter out) throws Exception{
		String selectManySql=
				"select no,name,phone,address from address";
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@192.168.15.09:1521:XE";
		String user="scott";
		String password="tiger";
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		Statement stmt=con.createStatement();
		
		ResultSet rs=
				stmt.executeQuery(selectManySql);
		if(rs.next()) {
			 do{
				int no=rs.getInt("no");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String address=rs.getString("address");
				out.println(no+"\t"+name+"\t"+phone+"\t"+address);
			 }while(rs.next());
		}else {
			out.println("친구없다");
		}
		
	}
}
