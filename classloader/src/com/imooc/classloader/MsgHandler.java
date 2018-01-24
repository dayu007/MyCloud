package com.imooc.classloader;

/**
 * @author dayu
 * @version 创建时间：2017年12月22日 下午5:20:42 类说明
 */
public class MsgHandler implements Runnable
{

	@Override
	public void run()
	{
		while (true)
		{
			BaseManager baseManager = ManagerFactory
					.getManager(ManagerFactory.MY_MANAGER);
			baseManager.logic();
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
