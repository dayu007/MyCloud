package com.imooc.classloader;
/**
 * @author dayu 
 * @version ����ʱ�䣺2017��12��22�� ����5:20:03
 * ��˵��
 */
public class MyClassLoadTest
{
    public static void main(String[] args)
    {
        new Thread(new MsgHandler()).start();
    }
}
