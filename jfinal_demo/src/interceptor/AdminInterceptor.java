package interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * @author dayu 
 * @version 创建时间：2017年12月14日 下午5:02:03
 * 类说明
 */
public class AdminInterceptor implements Interceptor
{
    
    public void intercept(Invocation inv)
    {
        System.out.println("==========AdminInterceptor.intercept()================");
    }
    
}
