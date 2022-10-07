package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	static {
		try {
			Class.forName("orcle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 완료!");

		} catch (ClassNotFoundException ex) {
			System.out.println("드라이버 로딩 실패 !!");
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"pc01", // 유저 아이디
					"java"); // 유저 비번
		} catch (SQLException ex) {
			System.out.println("DB 연결 실패!!");
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * 자원 반납
	 * @param conn
	 * @param stmt
	 * @param pstmt
	 * @param rs
	 */
	public static void close(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException ex) {
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException ex) {
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException ex) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException ex) {
			}
	}
}
