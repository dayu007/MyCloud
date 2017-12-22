package com.imooc.classloader;
/**
 * 实现java类的热加载功能
 * @author dayu 
 * @version 创建时间：2017年12月22日 下午4:44:17
 * 类说明
 */
public class MyManager implements BaseManager
{

    @Override
    public void logic()
    {
        System.out.println("测试打印语句123");
        System.out.println("打印效果真的好");
    }
    
}
