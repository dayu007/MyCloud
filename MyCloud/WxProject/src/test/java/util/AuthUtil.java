package mis.util;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class AuthUtil
{
	public static final String APPID="wx648a1940578fc041"; 
	public static final String APPSECRET="gh_a9bd137a1fd4"; 
	public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException{
		JSONObject jsonObject=null;
		DefaultHttpClient defaultHttpClient=new DefaultHttpClient();
		HttpGet httpGet=new HttpGet(url);
		HttpResponse resp = defaultHttpClient.execute(httpGet);
		
		HttpEntity entity = resp.getEntity();
		if(entity!=null){
			String str = EntityUtils.toString(entity);
			jsonObject = JSONObject.fromObject(str);
		}
		httpGet.releaseConnection();
		return jsonObject;
	}
}
