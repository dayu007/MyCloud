package controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

/**
 * @author dayu
 * @version 创建时间：2017年12月14日 下午4:05:15
 *          类说明
 */
public class UserController extends Controller
{
    public void index()
    {
        System.out.println("UserController.index()");
        renderText("UserController.index()");
    }
    
    public void getInfo()
    {
        System.out.println("UserController.getInfo()");
        renderText("UserController.getInfo()");
    }
}
