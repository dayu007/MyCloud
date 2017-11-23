package mis.dao;

import mis.domain.User;

public interface UserDao
{

	User getUserByOpenId(String openid);

	int updateUserByUserInfo(User user);

}
