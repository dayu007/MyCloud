package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;

/**
 * @author dayu 
 * @version 创建时间：2017年12月14日 下午5:24:01
 * 类说明
 */
public class ResourceHandler extends Handler
{
    
    @Override
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled)
    {
        // TODO Auto-generated method stub
        System.out.println("ResourceHandler.handle()");
    }
    
}
