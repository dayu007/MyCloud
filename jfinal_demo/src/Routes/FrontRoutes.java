package Routes;

import com.jfinal.config.Routes;

import controller.AdminController;
import controller.BlogController;
import controller.IndexController;
import controller.UserController;


/**
 * @author dayu 
 * @version 创建时间：2017年12月14日 下午4:29:53
 * 类说明
 */
public class FrontRoutes extends Routes
{
    @Override
    public void config()
    {
//        setBaseViewPath("WEB-INF/view/front");
        add("/", IndexController.class);
        add("/blog", BlogController.class);
    }
    
}
