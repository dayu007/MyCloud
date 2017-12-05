package test707.chatroom;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * 数据表msginfo的包装类
 * @author test707
 *
 */
public class Msg {
	/** 信息id */    private int id;
	/** 哪个聊天室 */ private String chatroom;
	/** 谁发的信息 */	private String msgfrom;
	/** 发给谁 */ 	private String msgto;
	/** 表情动作 */	private String chataction;
	/** 消息内容 */	private String msgcontent;
	/** 是否悄悄话 */	private int secret;
	
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
	 * 发送新消息
	 * 1.向数据表msginfo中插入消息数据
	 * 2.更新useronline的最近聊天时间
	 */
	public boolean saveToDB() {
		DBConn conn = null;
		try {
			conn= new DBConn();
			SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = myFmt.format(new java.util.Date());
			//插入消息元素
			String sql = "insert into msginfo values (null,?, ?, ?, ?, ?, ?,?);";
			PreparedStatement pStmt = conn.prepareStmt(sql);
			pStmt.setString(1, chatroom);
			pStmt.setString(2, msgfrom);
			if(msgto==null || msgto.equals("")) 
				msgto = "所有人";
			pStmt.setString(3, msgto);
			pStmt.setString(4, time);
			pStmt.setString(5, chataction);
			pStmt.setString(6, msgcontent);
			pStmt.setInt(7, secret);
			conn.executeUpdate();
			
			//更新该在线用户的最近聊天时间
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
	 * 从数据库中获取消息
	 * 消息特征：最新的N条 在某某chatroom 这N条消息时间较近的排后面，最新发的消息在最下面符合聊天习惯
	 * @param N
	 * @param chatroom
	 * @return	ArrayList Msg的数组链表
	 */
	public ArrayList<Msg> getTopMsg(int N, String chatroom) {
		DBConn conn = null;
		//保存消息的链表
		ArrayList<Msg> msgs = new ArrayList<Msg>();
		try {
			conn = new DBConn();
			//select id from msginfo where chatroom=? order by chattime desc limit ?;先查出最新N条消息
			//再将这N条消息正序排列，把最新消息显示在最下面
			String sql = "select * from  msginfo where id in (select t.id from (select id from msginfo where chatroom=? order by chattime desc limit ?) as t) order by chattime ;";
			PreparedStatement pStmt = conn.prepareStmt(sql);
			pStmt.setString(1, chatroom);
			pStmt.setInt(2, N);
			ResultSet rs = pStmt.executeQuery();
			//将消息一个个添加到链表中
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
