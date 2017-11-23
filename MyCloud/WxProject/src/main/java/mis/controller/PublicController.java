package mis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author dayu
 * @version 创建时间：2017年9月11日 下午1:56:45 类说明
 */
@Controller
public class PublicController
{
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gotodefault()
	{
		return "index";
	}

	@RequestMapping(value = "/400", method = RequestMethod.GET)
	public String go400()
	{
		return "400";
	}

	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String go404()
	{
		return "404";
	}
	@RequestMapping(value = "/405", method = RequestMethod.GET)
	public String go405()
	{
		return "405";
	}
	@RequestMapping(value = "/500", method = RequestMethod.GET)
	public String go500()
	{
		return "500";
	}
}
