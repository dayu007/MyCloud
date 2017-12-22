package com.imooc.classloader;

/**
 * 封装加载类的信息
 * 
 * @author dayu
 * @version 创建时间：2017年12月22日 下午4:43:04
 *          类说明
 */
public class LoadInfo
{
    // 自定义类加载
    private MyClassLoader myLoader;
    
    // 记录类的加载时间
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
