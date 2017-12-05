package test707.chatroom;

import java.sql.*;

public class DBConnDemo{
public static void main(String[] args) {
	
	DBConn conn = new DBConn();
	String sql = "select * from userinfo where username=?";
	PreparedStatement pStmt = conn.prepareStmt(sql);
	try {
		pStmt.setString(1,"π‹¿Ì‘±1");
		ResultSet rs = conn.executeQuery();
		if(rs.next()) {
			System.out.println("OK");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} 
	
}
}