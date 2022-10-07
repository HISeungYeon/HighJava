package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * db.properties파일의 내용으로 DB정보를 설정하는 방법
 * 방법1) properties 객체 이용하기
 */

public class JDBCUtil2 {
	
	static Properties prop; // properties 객체변수 선언
	
	static {
		
		prop = new Properties();
		
		
		try {
			prop.load(new FileInputStream("res/db.properties"));
			
			Class.forName(prop.getProperty("drive"));
			System.out.println("드라이버 로딩 완료!");

		} catch (ClassNotFoundException ex) {
			System.out.println("드라이버 로딩 실패 !!");
		}catch(IOException ex) {
			System.out.println("해당 파일이 없거나 입출력 오류 입니다.");
			ex.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("username"), // 유저 아이디
					prop.getProperty("password")); // 유저 비번
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
