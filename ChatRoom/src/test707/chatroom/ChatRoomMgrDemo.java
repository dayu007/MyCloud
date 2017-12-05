package test707.chatroom;

public class ChatRoomMgrDemo {
	public static void main(String[] args) {
		ChatRoomMgr crm = new ChatRoomMgr();
		
		//检测用户是否某个聊天室中 
		//也就是说 检测username 及对应的 chatroom是否在useronline的数据表中
		if(crm.isAtRoom("admin1","谈天说地")) {
			System.out.println("该用户在这个聊天室中");
		} else {
			System.out.println("该用户不在这个聊天室，或已经被T出这个聊天室");
		}
		//该用户从在线表useronline中删除
		if(crm.logout("admin")) {
			System.out.println("用户登出成功");
		} 
		
		//判断在线用户,在某个房间是否被禁言
		if(!crm.isDenyChat("aaa", "搞笑工专房")) {
			System.out.println("用户aaa在搞笑工专房没有被禁言");
		} else {
			System.out.println("用户aaa在搞笑工专房被禁言了");
		}
		
		//判断是否为管理员，选择开放功能
		if(crm.isAdmin("管理员1")) {
			System.out.println("该用户可以使用高级功能");
		} else {
			System.out.println("普通用户不能使用高级功能");
		}
	}
}
