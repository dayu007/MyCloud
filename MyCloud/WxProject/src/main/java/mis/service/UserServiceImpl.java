package mis.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mis.dao.UserDao;
import mis.domain.User;
@Service
public class UserServiceImpl implements UserService
{
	@Resource
	private UserDao userDao; 

	@Override
	public User getUserByOpenId(String openid)
	{
		User user=userDao.getUserByOpenId(openid);
		return user;
	}

	@Override
	public int updateUserByUserInfo(User user)
	{
		return userDao.updateUserByUserInfo(user);
		
	}

}
