package test707.chatroom;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInfoMgr {
	
	/**
	 * 登录检测
	 * 检测用户名密码，
	 * 以返回不同的字符串判断定结果
	 * @param username
	 * @param pass
	 * @return "_LOGIN_SUCCEED" 用户名和密码都正确
	 * 			"_WRONG_USER"   无此用户名
	 * 			"_WRONG_PASS"   有此用户名但是密码错误
	 */
	public String check(String username, String pass) {
		DBConn conn = null;
		String checkOut = null;
		try {
			//查询此用户名
			String sql = "select * from userinfo where username= ? ";
			conn = new DBConn();
			PreparedStatement pStmt = conn.prepareStmt(sql);
			pStmt.setString(1,username);
			ResultSet rs = conn.executeQuery();
			//判断数据库有无此用户名
			if(rs.next()) {
				//从数据库中得到此用户名的密码，并与传递进来的密码作比较
				if(rs.getString("pass").equals(pass)) {		
					SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String time = myFmt.format(new Date());
					//更新最后登陆时间
					sql = "update userinfo set lastlogintime= ? where username= ?;";
					pStmt = conn.prepareStmt(sql);
					pStmt.setString(1, time);
					pStmt.setString(2, username);
					conn.executeUpdate();
					//登陆成功标志
					checkOut = "_LOGIN_SUCCEED";
				} else 
					checkOut = "_WRONG_PASS";
			} else 
				checkOut = "_WRONG_USER";		//如果不设置checkOut变量，在外面也return一下，而只是在try{}里面直接return要出错 跟课本不一样，不知何解
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return checkOut;
	}  
	
	
	/**
	 * 注册
	 * 向数据库中插入注册用户信息
	 * 使用该方法之前要注意的是：务必先判断username在数据库中不存，不然会有相同的username,这样不符合userinfo的要求
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
