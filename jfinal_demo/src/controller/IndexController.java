package controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

/**
 * @author dayu
 * @version 创建时间：2017年12月14日 下午4:05:15
 *          类说明
 */
public class IndexController extends Controller
{
    public void index()
    {
        System.out.println("IndexController.index()");
        renderText("\"IndexController.index()\"");
//        render("index.html");
    }
    
    public void getInfo()
    {
        System.out.println("IndexController.getInfo()");
        renderText("IndexController.getInfo()");
    }
}
