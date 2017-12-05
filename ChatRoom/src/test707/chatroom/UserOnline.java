package test707.chatroom;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserOnline {
	/**
	 * 得到在线用户数
	 * @param chatroom
	 * @return
	 */
	public int countUser(String chatroom) {
		int count = 0;
		DBConn conn = null;
		try {
			conn = new DBConn();
			//数一下useronline表中这个chatromm的个数
			String sql = "select count(*) from useronline where chatroom=?";
			PreparedStatement pStmt = conn.prepareStmt(sql);
			pStmt.setString(1, chatroom);
			ResultSet rs = conn.executeQuery();
			rs.next();
			count = rs.getInt(1);
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			conn.close();
		}
		
	}
	
	/**
	 * 添加在线用户并马上发出系统公告表示欢迎新用户加入聊天室
	 * 2个操作都是向数据库插入的过程
	 * @param chatroom
	 * @param username
	 * @return
	 */
	public boolean addUserOnline(String chatroom, String username) {
		DBConn conn = null;
		try {
			conn = new DBConn();
			
			//添加在线用户
			String sql = "insert into useronline values (null,?,? ,null,null,null)" ;
			PreparedStatement pStmt = conn.prepareStmt(sql);
			pStmt.setString(1, chatroom);
			pStmt.setString(2, username);
			conn.executeUpdate();
			pStmt.close();
			
			//如果mysql中一个now()就搞定，还需要以下2句做什么，最多就套用格式而已
			SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = myFmt.format(new Date());
			
			//新用户加入聊天室，系统对聊天室内所有人发出公告，表示欢迎
			sql = "insert into msginfo values (null, ?,?, ?, ?, ?, ?,0)";
			pStmt = conn.prepareStmt(sql);
			pStmt.setString(1, chatroom);
			pStmt.setString(2, "系统公告");
			pStmt.setString(3, "所有人");
			pStmt.setString(4, time);
			pStmt.setString(5, "说：");
			pStmt.setString(6, "<font color=red>"+username+"</font>进入了聊天室，大家欢迎！");
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
