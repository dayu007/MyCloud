package controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

/**
 * @author dayu
 */
public class HelloController extends Controller
{
    public void index()
    {
        renderText("Hello JFinal World.");
    }
    
    @ActionKey("/mo")
    public void sayMorning(){
        renderText("Good Morning!");
    }

    public void sayBye(){
        renderText("GoodBye!");
    }
}