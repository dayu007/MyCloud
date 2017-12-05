package test707.chatroom;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ע�� �����ݿ��в���ע���û���Ϣ
 * ʹ�ø÷���֮ǰҪע����ǣ�������ж�username�����ݿ��в��棬��Ȼ������ͬ��username,����������userinfo��Ҫ��
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