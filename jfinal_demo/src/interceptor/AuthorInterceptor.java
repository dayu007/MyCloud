package interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * @author dayu 
 * @version 创建时间：2017年12月14日 下午5:21:13
 * 类说明
 */
public class AuthorInterceptor implements Interceptor
{
    
    public void intercept(Invocation inv)
    {
        // TODO Auto-generated method stub
        System.out.println("=====全局拦截器=AuthorInterceptor.intercept()=====");
    }
    
}
