package domain;

import java.io.Serializable;

/**
 * @author dayu
 * @version 创建时间：2017年12月14日 下午5:11:46
 *          类说明
 */
public class User implements Serializable
{
    private static final long serialVersionUID = 1059935267295004800L;
    
    private int userid;
    
    private String username;
    
    private int schoolid;
    
    private String loginname;
    
    private String e_mail;
    
    private String password;
    
    public int getUserid()
    {
        return userid;
    }
    
    public void setUserid(int userid)
    {
        this.userid = userid;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public int getSchoolid()
    {
        return schoolid;
    }
    
    public void setSchoolid(int schoolid)
    {
        this.schoolid = schoolid;
    }
    
    public String getLoginname()
    {
        return loginname;
    }
    
    public void setLoginname(String loginname)
    {
        this.loginname = loginname;
    }
    
    public String getE_mail()
    {
        return e_mail;
    }
    
    public void setE_mail(String e_mail)
    {
        this.e_mail = e_mail;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
}
