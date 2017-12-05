package test707.chatroom;

import java.util.ArrayList;
import java.util.Iterator;

public class MsgDemo {
	public static void main(String[] args) {
		
		//使用示例1，构造方法添加属性值
		for(int i=6; i<35; i++) {
		Msg msg = new Msg("谈天说地","管理员1","普通会员0","非悄悄地说",""+i,0);
		if(msg.saveToDB()) 
			System.out.println("已经成功向数据表msginfo添加数据");
		}
		/*
		//使用示例2: 构造空方法，一个个setter
		Msg msg2 = new Msg();
		msg2.setChatroom("谈天说地");
		msg2.setMsgfrom("管理员1");
		msg2.setMsgto("普通会员0");
		msg2.setChataction("严肃地说");
		msg2.setMsgcontent("你的号被我删了");
		msg2.setSecret(1);
		if(msg2.saveToDB()) 
			System.out.println("已经成功向数据表msginfo添加数据");
		String chatroom = "谈天说地";
		*/
		Msg msg3 = new Msg();
		String chatroom = "谈天说地";
		ArrayList<Msg> msgs = msg3.getTopMsg(6,chatroom);
System.out.println("11");
		Iterator itr = msgs.iterator();
		while(itr.hasNext()) {
			Msg m = (Msg)itr.next();
			String msgString = m.getId()+""+m.getMsgfrom()+" 对 "+m.getMsgto()+""+m.getChataction()+""+m.getMsgcontent();
			System.out.println(msgString);
		}
	}
}
