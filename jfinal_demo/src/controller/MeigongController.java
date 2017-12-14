package controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

/**
 * @author dayu
 * @version 创建时间：2017年12月14日 下午4:52:14
 *          类说明
 */
public class MeigongController extends Controller
{
    @ActionKey("/mei")
    public void index()
    {
        System.out.println("MeigongController.index()");
        renderText("MeigongController.index()");
    }
    
    public void haoren()
    {
        System.out.println("MeigongController.haoren()");
        renderText("MeigongController.haoren()");
    }
}
