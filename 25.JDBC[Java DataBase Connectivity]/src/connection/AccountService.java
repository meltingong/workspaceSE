package connection;

import java.sql.*;

import dao.common.*;

public class AccountService {
	
	private DataSource dataSource;
	
	public AccountService() {
		dataSource = new DataSource();
	}
	
	/*
	 * 모든 계좌의 잔고를 balance만큼 갱신
	 */
	
	public void updateBalance(int balance) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String updateSQL = "update accounta set acc_balance = acc_balance + ? where acc_no = ? ";
		
		try {
			con = dataSource.getConnection();
			System.out.println("------ updateBalance transaction start ------");
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(updateSQL);
			
			/**************************10000번 계좌 update****************************/
			int acc_no = 10000;
			pstmt.setInt(1, balance);
			pstmt.setInt(2, acc_no);
			int rowCount = pstmt.executeUpdate();
			System.out.println(acc_no + "번 계좌" + rowCount + " 행 update");
			
			/**************************20000번 계좌 update****************************/
			acc_no = 20000;
			pstmt.setInt(1, balance);
			pstmt.setInt(2, acc_no);
			rowCount = pstmt.executeUpdate();
			System.out.println(acc_no + "번 계좌" + rowCount + " 행 update");
			
			/**************************30000번 계좌 update****************************/
			acc_no = 30000;
			pstmt.setInt(1, balance);
			pstmt.setInt(2, acc_no);
			rowCount = pstmt.executeUpdate();
			System.out.println(acc_no + "번 계좌" + rowCount + " 행 update");
			
			/**************************40000번 계좌 update****************************/
			acc_no = 40000;
			pstmt.setInt(1, balance);
			pstmt.setInt(2, acc_no);
			rowCount = pstmt.executeUpdate();
			System.out.println(acc_no + "번 계좌" + rowCount + " 행 update");
			
			/**************************50000번 계좌 update****************************/
			acc_no = 50000;
			pstmt.setInt(1, balance);
			pstmt.setInt(2, acc_no);
			rowCount = pstmt.executeUpdate();
			System.out.println(acc_no + "번 계좌" + rowCount + " 행 update");
			
			/**************************60000번 계좌 update****************************/
			acc_no = 60000;
			pstmt.setInt(1, balance);
			pstmt.setInt(2, acc_no);
			rowCount = pstmt.executeUpdate();
			System.out.println(acc_no + "번 계좌" + rowCount + " 행 update");
			System.out.println("------ updateBalance transaction end[commit] ------");
			con.commit();
			
		} catch (Exception e) {
			System.out.println("99.예외발생 : " + e.getMessage());
			System.out.println("------ updateBalance transaction end[rollback] ------");
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
		}finally {
			/*
			 * exception발생유무와 상관없이 항상 실행
			 * 		- 리소스 해지
			 */
			try {
				dataSource.close(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}

	
	
	
}
