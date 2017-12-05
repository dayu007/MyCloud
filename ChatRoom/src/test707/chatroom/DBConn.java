package test707.chatroom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
	String url = "jdbc:mysql://localhost:3306/chatroom?user=root&password=kingMySql1204!";
	Connection conn;
	Statement stmt;
	PreparedStatement pStmt;
	ResultSet rs;
	
	/**
	 * 构造方法
	 * 直接取得连接conn
	 */
	public DBConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public Statement createStmt() {
		try {
			stmt =  conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	//预处理
	public PreparedStatement prepareStmt(String sql) {
		try {
			pStmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pStmt;
	}
	//pStmt执行查询语句，返回rs
	public ResultSet executeQuery() {
		try {
			rs = pStmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	//pStmt执行更新语句
	public int executeUpdate() {
		int r = 0;
		try {
			//自动提交设false之前要保护现场
			boolean a = conn.getAutoCommit();
			//更新操作需要手动提交
			conn.setAutoCommit(false);
			//更新操作
			r = pStmt.executeUpdate();
			conn.commit();
			conn.setAutoCommit(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	//关闭
	public void close() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(pStmt != null) {
				pStmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
}
