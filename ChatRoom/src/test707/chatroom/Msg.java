package test707.chatroom;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * ���ݱ�msginfo�İ�װ��
 * @author test707
 *
 */
public class Msg {
	/** ��Ϣid */    private int id;
	/** �ĸ������� */ private String chatroom;
	/** ˭������Ϣ */	private String msgfrom;
	/** ����˭ */ 	private String msgto;
	/** ���鶯�� */	private String chataction;
	/** ��Ϣ���� */	private String msgcontent;
	/** �Ƿ����Ļ� */	private int secret;
	
	//---------------//
	//--Constructor--//
	//--------------//
	public Msg(String chatroom, String msgfrom, String msgto, String chataction,
			String msgcontent, int secret) {
		this.chatroom = chatroom;
		this.msgfrom = msgfrom;
		this.msgto = msgto;
		this.chataction = chataction;
		this.msgcontent = msgcontent;
		this.secret = secret;
	}
	public Msg() {}
	
	//----------//
	//--getter--//
	//----------//
	public int getId() {
		return id;
	}
	public String getChatroom() {
		return chatroom;
	}
	public String getMsgfrom() {
		return msgfrom;
	}
	public String getMsgto() {
		return msgto;
	}
	public String getChataction() {
		return chataction;
	}
	public String getMsgcontent() {
		return msgcontent;
	}
	public int getSecret() {
		return secret;
	}
	//----------//
	//--setter--//
	//----------//
	public void setId(int id) {
		this.id = id;
	}
	public void setChatroom(String chatroom) {
		this.chatroom = chatroom;
	}
	public void setMsgfrom(String msgfrom) {
		this.msgfrom = msgfrom;
	}
	public void setMsgto(String msgto) {
		this.msgto = msgto;
	}
	public void setChataction(String chataction) {
		this.chataction = chataction;
	}
	public void setMsgcontent(String msgcontent) {
		this.msgcontent = msgcontent;
	}
	public void setSecret(int secret) {
		this.secret = secret;
	}
	
	/**
	 * ��������Ϣ
	 * 1.�����ݱ�msginfo�в�����Ϣ����
	 * 2.����useronline���������ʱ��
	 */
	public boolean saveToDB() {
		DBConn conn = null;
		try {
			conn= new DBConn();
			SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = myFmt.format(new java.util.Date());
			//������ϢԪ��
			String sql = "insert into msginfo values (null,?, ?, ?, ?, ?, ?,?);";
			PreparedStatement pStmt = conn.prepareStmt(sql);
			pStmt.setString(1, chatroom);
			pStmt.setString(2, msgfrom);
			if(msgto==null || msgto.equals("")) 
				msgto = "������";
			pStmt.setString(3, msgto);
			pStmt.setString(4, time);
			pStmt.setString(5, chataction);
			pStmt.setString(6, msgcontent);
			pStmt.setInt(7, secret);
			conn.executeUpdate();
			
			//���¸������û����������ʱ��
			sql = "update useronline set lastchattime=? where username=? and chatroom=? ";
			pStmt = conn.prepareStmt(sql);
			pStmt.setString(1, time);
			pStmt.setString(2, msgfrom);
			pStmt.setString(3, chatroom);
			conn.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			conn.close();
		}
	}
	
	/**
	 * �����ݿ��л�ȡ��Ϣ
	 * ��Ϣ���������µ�N�� ��ĳĳchatroom ��N����Ϣʱ��Ͻ����ź��棬���·�����Ϣ���������������ϰ��
	 * @param N
	 * @param chatroom
	 * @return	ArrayList Msg����������
	 */
	public ArrayList<Msg> getTopMsg(int N, String chatroom) {
		DBConn conn = null;
		//������Ϣ������
		ArrayList<Msg> msgs = new ArrayList<Msg>();
		try {
			conn = new DBConn();
			//select id from msginfo where chatroom=? order by chattime desc limit ?;�Ȳ������N����Ϣ
			//�ٽ���N����Ϣ�������У���������Ϣ��ʾ��������
			String sql = "select * from  msginfo where id in (select t.id from (select id from msginfo where chatroom=? order by chattime desc limit ?) as t) order by chattime ;";
			PreparedStatement pStmt = conn.prepareStmt(sql);
			pStmt.setString(1, chatroom);
			pStmt.setInt(2, N);
			ResultSet rs = pStmt.executeQuery();
			//����Ϣһ������ӵ�������
			while(rs.next()) {
				Msg m = new Msg();
				m.id = rs.getInt(1);
				m.msgfrom = rs.getString(3);	
				m.msgto =rs.getString(4);
				m.chataction = rs.getString(6);
				m.msgcontent = rs.getString(7);
				m.secret = rs.getInt(8);
				msgs.add(m);
			}
			return msgs;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return msgs;
	}
}
