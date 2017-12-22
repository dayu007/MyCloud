package com.imooc.classloader;

/**
 * ��װ���������Ϣ
 * 
 * @author dayu
 * @version ����ʱ�䣺2017��12��22�� ����4:43:04
 *          ��˵��
 */
public class LoadInfo
{
    // �Զ��������
    private MyClassLoader myLoader;
    
    // ��¼��ļ���ʱ��
    private long longTime;
    
    private BaseManager manager;
    
    public LoadInfo(MyClassLoader myLoader,long longTime)
    {
        super();
        this.longTime = longTime;
        this.myLoader = myLoader;
    }
    
    public BaseManager getManager()
    {
        return manager;
    }
    
    public void setManager(BaseManager manager)
    {
        this.manager = manager;
    }
    
    public long getLongTime()
    {
        return longTime;
    }
    
    public void setLongTime(long longTime)
    {
        this.longTime = longTime;
    }
    
    public MyClassLoader getMyLoader()
    {
        return myLoader;
    }
    
    public void setMyLoader(MyClassLoader myLoader)
    {
        this.myLoader = myLoader;
    }
    
}
