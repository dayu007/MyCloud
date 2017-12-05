package test707.chatroom;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 注册 向数据库中插入注册用户信息
 * 使用该方法之前要注意的是：务必先判断username在数据库中不存，不然会有相同的username,这样不符合userinfo的要求
 * 
 * @param username
 * @param pass
 * @return
 */
public class SaveToDB {
	public boolean savaToDB(String username, String pass) {
		DBConn conn = null;
		try {
			SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = myFmt.format(new Date());
			conn = new DBConn();
			String sql = "insert into userinfo values (null, ?, ?, ?, 0)";
			PreparedStatement pStmt = conn.prepareStmt(sql);
			pStmt.setString(1, username);
			pStmt.setString(2, pass);
			pStmt.setString(3, time);
			conn.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			conn.close();
		}
	}
}