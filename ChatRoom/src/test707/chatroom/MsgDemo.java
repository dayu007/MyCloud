package test707.chatroom;

import java.util.ArrayList;
import java.util.Iterator;

public class MsgDemo {
	public static void main(String[] args) {
		
		//ʹ��ʾ��1�����췽���������ֵ
		for(int i=6; i<35; i++) {
		Msg msg = new Msg("̸��˵��","����Ա1","��ͨ��Ա0","�����ĵ�˵",""+i,0);
		if(msg.saveToDB()) 
			System.out.println("�Ѿ��ɹ������ݱ�msginfo�������");
		}
		/*
		//ʹ��ʾ��2: ����շ�����һ����setter
		Msg msg2 = new Msg();
		msg2.setChatroom("̸��˵��");
		msg2.setMsgfrom("����Ա1");
		msg2.setMsgto("��ͨ��Ա0");
		msg2.setChataction("�����˵");
		msg2.setMsgcontent("��ĺű���ɾ��");
		msg2.setSecret(1);
		if(msg2.saveToDB()) 
			System.out.println("�Ѿ��ɹ������ݱ�msginfo�������");
		String chatroom = "̸��˵��";
		*/
		Msg msg3 = new Msg();
		String chatroom = "̸��˵��";
		ArrayList<Msg> msgs = msg3.getTopMsg(6,chatroom);
System.out.println("11");
		Iterator itr = msgs.iterator();
		while(itr.hasNext()) {
			Msg m = (Msg)itr.next();
			String msgString = m.getId()+""+m.getMsgfrom()+" �� "+m.getMsgto()+""+m.getChataction()+""+m.getMsgcontent();
			System.out.println(msgString);
		}
	}
}
