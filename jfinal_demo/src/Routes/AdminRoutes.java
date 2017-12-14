package Routes;

import interceptor.AdminInterceptor;

import com.jfinal.config.Routes;

import controller.AdminController;
import controller.MeigongController;
import controller.UserController;

/**
 * @author dayu
 * @version 创建时间：2017年12月14日 下午4:29:53
 *          类说明
 */
public class AdminRoutes extends Routes
{
    @Override
    public void config()
    {
        // 设置页面路径
        // setBaseViewPath("/view/admin");
        add("/admin", AdminController.class);
        add("/admin/user", UserController.class);
        add("/admin/meigong", MeigongController.class);
        addInterceptor(new AdminInterceptor());
    }
    
}
