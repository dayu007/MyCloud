package mis.service;

import mis.domain.User;

public interface UserService
{
	User getUserByOpenId(String openid);
	
	 int updateUserByUserInfo(User user);
	
}
