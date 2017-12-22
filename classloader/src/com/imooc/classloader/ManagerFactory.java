package com.imooc.classloader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dayu
 * @version 创建时间：2017年12月22日 下午4:51:19
 *          类说明
 */
public class ManagerFactory
{
    // 记录热加载类的加载信息
    private static final Map<String, LoadInfo> loadTimeMap = new HashMap<String, LoadInfo>();
    
    // 要加载的类的classpath
    private static final String CLASS_PATH = "E:/dayu/workspace/classloader/bin";
    
    // 热加载类的全名称
    public static final String MY_MANAGER = "com.imooc.classloader.MyManager";
    
    public static BaseManager getManager(String className)
    {
        File loadFile = new File(CLASS_PATH + className.replaceAll("\\.", "/") + ".class");
        long lastModified = loadFile.lastModified();
        
        if (loadTimeMap.get(className) == null)
        {
            load(className, lastModified);
        }// 加载类的时间戳变化了，同样需要重新加载这个类到JVM
        else if (loadTimeMap.get(className).getLongTime() != lastModified)
        {
            load(className, lastModified);
        }
        return null;
    }
    
    private static void load(String className, long lastModified)
    {
        MyClassLoader classLoader = new MyClassLoader(CLASS_PATH);
        Class<?> loadClass = null;
        try
        {
            loadClass = classLoader.loadClass(className);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        BaseManager baseManager = newInstance(loadClass);
        LoadInfo info = new LoadInfo(classLoader, lastModified);
        info.setManager(baseManager);
        loadTimeMap.put(className, info);
    }
    
    private static BaseManager newInstance(Class<?> loadClass)
    {
        try
        {
            return (BaseManager)loadClass.getConstructor(new Class[] {}).newInstance(new Object[] {});
        }
        catch (InstantiationException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalArgumentException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (NoSuchMethodException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SecurityException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
}
