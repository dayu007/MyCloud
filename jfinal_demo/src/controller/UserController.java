package controller;

import com.jfinal.core.Controller;

import domain.User;

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
        User user = getBean(User.class);
//        User user= getModel(User.class);
        System.out.println("UserController.getInfo()userId="+user.getUserid()+""+user.getUsername()+user.getLoginname());
        renderText("UserController.getInfo()" + "name:"+"UserController.getInfo()userId="+user.getUserid()+""+user.getUsername()+user.getLoginname());
    }
}
