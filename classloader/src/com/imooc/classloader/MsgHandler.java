package com.imooc.classloader;
/**
 * @author dayu 
 * @version ����ʱ�䣺2017��12��22�� ����5:20:42
 * ��˵��
 */
public class MsgHandler implements Runnable
{

    @Override
    public void run()
    {
        while(true){
            BaseManager baseManager=ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
            baseManager.logic();
            try
            {
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
}
