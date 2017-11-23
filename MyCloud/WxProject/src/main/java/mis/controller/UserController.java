package mis.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mis.service.UserService;
import mis.util.AuthUtil;
import net.sf.json.JSONObject;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController
{
	private UserService userService;
	@RequestMapping("/login")
	public String login(){
		String callbackUrl="/callback";
		String url="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AuthUtil.APPID
				+ "&redirect_uri="+URLEncoder.encode(callbackUrl)
				+ "&response_type=code"
				+ "&scope=snsapi_userinfo"
				+ "&state=STATE#wechat_redirect";	
		return "redirect:callback"; 
	}

	@RequestMapping("/callback")
	public String callBack(HttpServletRequest request,HttpServletResponse resp) throws ClientProtocolException, IOException{
		String code = request.getParameter("code");
		String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+AuthUtil.APPID
				+ "&secret="+AuthUtil.APPSECRET
				+ "&code="+code
				+ "&grant_type=authorization_code ";
		JSONObject json = AuthUtil.doGetJson(url);
		String token = json.getString("access_token");
		String openid = json.getString("openid");
		System.out.println("openid="+openid+",token="+token);
		
		String infoUrl="https://api.weixin.qq.com/sns/userinfo?access_token="+token
				+ "&openid="+openid
				+ "&lang=zh_CN ";		
		return ""; 
	}

}
