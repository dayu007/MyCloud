package test707.chatroom;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChatRoomMgr {
	/**
	 * ����Ƿ����Ա
	 * �����userinfo�и��û���role�Ƿ�Ϊ1
	 * @param username
	 * @return	true �ǹ���Ա
	 * 			false ���ǹ���Ա
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
	 * �ж��û��Ƿ���useronline����
	 * ��;���ж��û��Ƿ��߳�����
	 * @param username
	 * @param chatroom
	 * @return	true �Ѿ����߳�����
	 * 			false ���ڷ�����
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
			//�ж�useronline���޴��û���
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
	 * ���Լ�⣨��ʱ�Ȳ��ô˹��ܣ�
	 * �ж������û�,��ĳ�������Ƿ񱻽���
	 * ��;������Ϣʱ�жϣ�
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
			//�ж�useronline���޴��û���
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
	 * ָ��username�ǳ� ����useronline��ɾ��
	 * ��;���û������뿪������ 
	 * 		�û�������Ա�߳�����
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
	 * ָ��username��chatroom �ǳ� ����useronline��ɾ��
	 * ��;���뿪�����ң�Ҫѡ������������ʱ
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
	 * ָ��username�ǳ� ����userinfo��ɾ��
	 * ��;������Ա ɾ���û�
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
