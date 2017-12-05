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
	 * ���췽��
	 * ֱ��ȡ������conn
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
	
	//Ԥ����
	public PreparedStatement prepareStmt(String sql) {
		try {
			pStmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pStmt;
	}
	//pStmtִ�в�ѯ��䣬����rs
	public ResultSet executeQuery() {
		try {
			rs = pStmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	//pStmtִ�и������
	public int executeUpdate() {
		int r = 0;
		try {
			//�Զ��ύ��false֮ǰҪ�����ֳ�
			boolean a = conn.getAutoCommit();
			//���²�����Ҫ�ֶ��ύ
			conn.setAutoCommit(false);
			//���²���
			r = pStmt.executeUpdate();
			conn.commit();
			conn.setAutoCommit(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	//�ر�
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
