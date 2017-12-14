package controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

/**
 * @author dayu
 * @version 创建时间：2017年12月14日 下午4:05:15
 *          类说明
 */
public class AdminController extends Controller
{
    public String index()
    {
        // renderText("this is an admin operation!");
//        render("index.html");
        return "index.html";
    }
    
//    @ActionKey("/getuser")
    public void readAllUser()
    {
        String age = getPara(0);
        String name = getPara(1, "yunxue");
        
        renderText("do get all user in db!      name:"+name+",age:"+age);
    }
}
