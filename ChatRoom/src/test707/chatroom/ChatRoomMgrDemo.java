package test707.chatroom;

public class ChatRoomMgrDemo {
	public static void main(String[] args) {
		ChatRoomMgr crm = new ChatRoomMgr();
		
		//����û��Ƿ�ĳ���������� 
		//Ҳ����˵ ���username ����Ӧ�� chatroom�Ƿ���useronline�����ݱ���
		if(crm.isAtRoom("admin1","̸��˵��")) {
			System.out.println("���û��������������");
		} else {
			System.out.println("���û�������������ң����Ѿ���T�����������");
		}
		//���û������߱�useronline��ɾ��
		if(crm.logout("admin")) {
			System.out.println("�û��ǳ��ɹ�");
		} 
		
		//�ж������û�,��ĳ�������Ƿ񱻽���
		if(!crm.isDenyChat("aaa", "��Ц��ר��")) {
			System.out.println("�û�aaa�ڸ�Ц��ר��û�б�����");
		} else {
			System.out.println("�û�aaa�ڸ�Ц��ר����������");
		}
		
		//�ж��Ƿ�Ϊ����Ա��ѡ�񿪷Ź���
		if(crm.isAdmin("����Ա1")) {
			System.out.println("���û�����ʹ�ø߼�����");
		} else {
			System.out.println("��ͨ�û�����ʹ�ø߼�����");
		}
	}
}
