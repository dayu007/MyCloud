package demo;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.redis.RedisPlugin;
import com.jfinal.template.Engine;

/**
 * @author dayu
 * @version 创建时间：2017年12月14日 下午5:39:21
 *          类说明
 */
public class AppConfig extends JFinalConfig
{
    public void configConstant(Constants me)
    {
        // 第一次使用use加载的配置将成为主配置，可以通过PropKit.get(...)直接取值
        PropKit.use("a_little_config.txt");
        me.setDevMode(PropKit.getBoolean("devMode"));
    }
    
    public void configPlugin(Plugins me)
    {
        // 非第一次使用use加载的配置，需要通过每次使用use来指定配置文件名再来取值
        String redisHost = PropKit.use("redis_config.txt").get("host");
        int redisPort = PropKit.use("redis_config.txt").getInt("port");
        RedisPlugin rp = new RedisPlugin("myRedis", redisHost, redisPort);
        me.add(rp);
        // 非第一次使用 use加载的配置，也可以先得到一个Prop对象，再通过该对象来获取值
        Prop p = PropKit.use("db_config.txt");
        DruidPlugin dp = new DruidPlugin(p.get("jdbcUrl"), p.get("user"), p.get("password"));
        me.add(dp);
    }

    @Override
    public void configRoute(Routes me)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void configEngine(Engine me)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void configInterceptor(Interceptors me)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void configHandler(Handlers me)
    {
        // TODO Auto-generated method stub
        
    }
}