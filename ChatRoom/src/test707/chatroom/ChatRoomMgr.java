package test707.chatroom;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChatRoomMgr {
	/**
	 * 检测是否管理员
	 * 即检测userinfo中该用户的role是否为1
	 * @param username
	 * @return	true 是管理员
	 * 			false 不是管理员
	 */
	public boolean isAdmin(String username) {
		DBConn conn = null;
		boolean flag = false;
		try {
			String sql = "select role from userinfo where username=?";
			conn = new DBConn();
			PreparedStatement pStmt = conn.prepareStmt(sql);
			pStmt.setString(1,username);
			ResultSet rs = conn.executeQuery();
		    rs.next();
		    if(rs.getInt("role") != 1) {
		    	flag = false;
		    } else 
		    	flag = true;
				
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			conn.close();
		}
		return flag;
	}
	/**
	 * 判断用户是否在useronline表中
	 * 用途：判断用户是否被踢出房间
	 * @param username
	 * @param chatroom
	 * @return	true 已经被踢出房间
	 * 			false 还在房间中
	 */
	public boolean isAtRoom(String username, String chatroom) {
		DBConn conn = null;
		boolean flat = false;
		try {
			String sql = "select * from useronline where username=? and chatroom=? ";
			conn = new DBConn();
			PreparedStatement pStmt = conn.prepareStmt(sql);
			pStmt.setString(1,username);
			pStmt.setString(2, chatroom);
			ResultSet rs = conn.executeQuery();
			//判断useronline有无此用户名
			if(rs.next()) {
				flat = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			conn.close();
		}
		return flat;
	}
	
	/**
	 * 禁言检测（暂时先不用此功能）
	 * 判断在线用户,在某个房间是否被禁言
	 * 用途：发消息时判断，
	 * @param username
	 * @param chatroom
	 * @return
	 */
	public boolean isDenyChat(String username, String chatroom) {
		DBConn conn = null;
		boolean flag = false;
		try {
			String sql = "select denyroom from useronline where username=? and chatroom=? ";
			conn = new DBConn();
			PreparedStatement pStmt = conn.prepareStmt(sql);
			pStmt.setString(1,username);
			pStmt.setString(2, chatroom);
			ResultSet rs = conn.executeQuery();
			//判断useronline有无此用户名
			rs.next();
			String denyroom = rs.getString(1);
			if(denyroom == null || !denyroom.equals(chatroom)) {
				flag = false;
			}
			else if(denyroom.equals(chatroom)) {
				flag = true;
			} 		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			conn.close();
		}
		return flag;
	}
	
	/**
	 * 指定username登出 即从useronline中删除
	 * 用途：用户主动离开聊天室 
	 * 		用户被管理员踢出房间
	 * @param username
	 * @return
	 */
	public boolean logout(String username) {
		DBConn conn = null;
		boolean flat = false;
		try {
			String sql = "delete from useronline where username=?";
			conn = new DBConn();
			PreparedStatement pStmt = conn.prepareStmt(sql);
			pStmt.setString(1,username);
			conn.executeUpdate();
			flat = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			conn.close();
		}
		return flat;
	}
	/**
	 * 指定username和chatroom 登出 即从useronline中删除
	 * 用途：离开聊天室，要选择其他聊天室时
	 * @param username
	 * @param chatroom
	 * @return
	 */
	public boolean logout(String username, String chatroom) {
		DBConn conn = null;
		boolean flat = false;
		try {
			String sql = "delete from useronline where username=? and chatroom=?";
			conn = new DBConn();
			PreparedStatement pStmt = conn.prepareStmt(sql);
			pStmt.setString(1,username);
			pStmt.setString(2, chatroom);
			conn.executeUpdate();
			flat = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			conn.close();
		}
		return flat;
	}
	
	/**
	 * 指定username登出 即从userinfo中删除
	 * 用途：管理员 删除用户
	 * @param username
	 * @return
	 */
	public boolean deleteUser(String username) {
		DBConn conn = null;
		boolean flat = false;
		try {
			String sql = "delete from userinfo where username=?";
			conn = new DBConn();
			PreparedStatement pStmt = conn.prepareStmt(sql);
			pStmt.setString(1,username);
			conn.executeUpdate();
			flat = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			conn.close();
		}
		return flat;
	}
}
