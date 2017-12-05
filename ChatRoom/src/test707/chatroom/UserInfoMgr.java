package test707.chatroom;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInfoMgr {
	
	/**
	 * ��¼���
	 * ����û������룬
	 * �Է��ز�ͬ���ַ����ж϶����
	 * @param username
	 * @param pass
	 * @return "_LOGIN_SUCCEED" �û��������붼��ȷ
	 * 			"_WRONG_USER"   �޴��û���
	 * 			"_WRONG_PASS"   �д��û��������������
	 */
	public String check(String username, String pass) {
		DBConn conn = null;
		String checkOut = null;
		try {
			//��ѯ���û���
			String sql = "select * from userinfo where username= ? ";
			conn = new DBConn();
			PreparedStatement pStmt = conn.prepareStmt(sql);
			pStmt.setString(1,username);
			ResultSet rs = conn.executeQuery();
			//�ж����ݿ����޴��û���
			if(rs.next()) {
				//�����ݿ��еõ����û��������룬���봫�ݽ������������Ƚ�
				if(rs.getString("pass").equals(pass)) {		
					SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String time = myFmt.format(new Date());
					//��������½ʱ��
					sql = "update userinfo set lastlogintime= ? where username= ?;";
					pStmt = conn.prepareStmt(sql);
					pStmt.setString(1, time);
					pStmt.setString(2, username);
					conn.executeUpdate();
					//��½�ɹ���־
					checkOut = "_LOGIN_SUCCEED";
				} else 
					checkOut = "_WRONG_PASS";
			} else 
				checkOut = "_WRONG_USER";		//���������checkOut������������Ҳreturnһ�£���ֻ����try{}����ֱ��returnҪ���� ���α���һ������֪�ν�
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return checkOut;
	}  
	
	
	/**
	 * ע��
	 * �����ݿ��в���ע���û���Ϣ
	 * ʹ�ø÷���֮ǰҪע����ǣ�������ж�username�����ݿ��в��棬��Ȼ������ͬ��username,����������userinfo��Ҫ��
	 * @param username
	 * @param pass
	 * @return
	 */
	
	public boolean savaToDB(String username, String pass) {
		DBConn conn = null;
		try {
			SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
