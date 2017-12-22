package com.imooc.classloader;
/**
 * @author dayu 
 * @version 创建时间：2017年12月22日 下午5:20:03
 * 类说明
 */
public class MyClassLoadTest
{
    public static void main(String[] args)
    {
        System.out.println("MyClassLoadTest.main()");
        new Thread(new MsgHandler()).start();
    }
}
