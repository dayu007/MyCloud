package test707.chatroom;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserOnline {
	/**
	 * �õ������û���
	 * @param chatroom
	 * @return
	 */
	public int countUser(String chatroom) {
		int count = 0;
		DBConn conn = null;
		try {
			conn = new DBConn();
			//��һ��useronline�������chatromm�ĸ���
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
	 * ��������û������Ϸ���ϵͳ�����ʾ��ӭ���û�����������
	 * 2���������������ݿ����Ĺ���
	 * @param chatroom
	 * @param username
	 * @return
	 */
	public boolean addUserOnline(String chatroom, String username) {
		DBConn conn = null;
		try {
			conn = new DBConn();
			
			//��������û�
			String sql = "insert into useronline values (null,?,? ,null,null,null)" ;
			PreparedStatement pStmt = conn.prepareStmt(sql);
			pStmt.setString(1, chatroom);
			pStmt.setString(2, username);
			conn.executeUpdate();
			pStmt.close();
			
			//���mysql��һ��now()�͸㶨������Ҫ����2����ʲô���������ø�ʽ����
			SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = myFmt.format(new Date());
			
			//���û����������ң�ϵͳ���������������˷������棬��ʾ��ӭ
			sql = "insert into msginfo values (null, ?,?, ?, ?, ?, ?,0)";
			pStmt = conn.prepareStmt(sql);
			pStmt.setString(1, chatroom);
			pStmt.setString(2, "ϵͳ����");
			pStmt.setString(3, "������");
			pStmt.setString(4, time);
			pStmt.setString(5, "˵��");
			pStmt.setString(6, "<font color=red>"+username+"</font>�����������ң���һ�ӭ��");
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
