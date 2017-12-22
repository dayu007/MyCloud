package controller;

import com.jfinal.core.Controller;

/**
 * @author dayu
 * @version 创建时间：2017年12月14日 下午4:05:15
 *          类说明
 */
public class BlogController extends Controller
{
    public void index()
    {
        System.out.println("BlogController.index()");
        renderText("BlogController.index()");
    }
    
    public void getInfo()
    {
       System.out.println("BlogController.getInfo()");
//        renderText("BlogController.getInfo()");
//       render("index.html");
       renderText("BlogController.getInfo()");
    }
}
