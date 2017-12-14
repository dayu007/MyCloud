package demo;

import org.eclipse.jetty.server.Authentication.User;

import handler.ResourceHandler;
import interceptor.AuthorInterceptor;
import Routes.AdminRoutes;
import Routes.FrontRoutes;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

import controller.AdminController;
import controller.HelloController;

// import domain.User;

/**
 * @author dayu
 * @version 创建时间：2017年12月14日 下午3:46:37
 *          类说明
 */
public class DemoConfig extends JFinalConfig
{
    
    public static void main(String[] args)
    {
        JFinal.start("WebRoot", 80, "/");
    }
    
    public void configConstant(Constants me)
    {
        // me.setDevMode(true);
        PropKit.use("a_little_config.txt");
        me.setDevMode(PropKit.getBoolean("devMode"));//
    }
    
    public void configRoute(Routes me)
    {
        // me.add("/hello", HelloController.class);
        // me.add("admin", AdminController.class);
        me.add(new AdminRoutes());
        me.add(new FrontRoutes());
    }
    
    /**
     * 配置template engine
     */
    public void configEngine(Engine me)
    {
        // me.addSharedFunction("");
        // me.addSharedFunction("");
        // me.addSharedFunction("");
    }
    
    /**
     * 配置Druid数据库连接池与ActiveRecord数据库访问插件
     */
    public void configPlugin(Plugins me)
    {
        loadPropertyFile("mydatabase.txt");
        DruidPlugin dp = new DruidPlugin(getProperty("url"), getProperty("username"), getProperty("password"));
        me.add(dp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        me.add(arp);
        // TODO 配置数据库表对应实例
        arp.addMapping("user", (Class<? extends Model<?>>)User.class);
        
    }
    
    /**
     * 配置JFinal的全局拦截器，全局拦截器的所有action请求，除非使用@Clear在Controller中清除，
     * 如下配置了名为AuthorInterceptor的拦截器
     * Interceptor 配置粒度分为Global、Inject、Class、Method 四个层次
     */
    public void configInterceptor(Interceptors me)
    {
        me.add(new AuthorInterceptor());
    }
    
    /**
     * 配置JFinal的Handler，如下配置了ResourceHandler的处理器，
     * Handler可以接管所有web请求，并对应用拥有完全的控制权，能更好的实现更高层的功能性扩展
     */
    public void configHandler(Handlers me)
    {
        me.add(new ResourceHandler());
    }
}