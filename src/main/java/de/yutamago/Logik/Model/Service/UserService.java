package de.yutamago.Logik.Model.Service;

import de.yutamago.Logik.Model.Entity.User;
import de.yutamago.Persistenz.Dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Angelo on 04.12.2016.
 */
@Service
public class UserService {

	@Autowired
	@Qualifier("FakeDB")
	private IUserDao userDao;


	public Collection<User> getUsers() {
		return userDao.getUsers();
	}

	public User getUser(String username) throws IllegalArgumentException {
		User user = userDao.getUser(username);

		if (user == null) {
			throw new IllegalArgumentException("User with this name does not exist.");
		}

		return user;
	}

	public User insertUser(User user) {
		return userDao.insertUser(user);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public void deleteUser(String username) {
		userDao.deleteUser(username);
	}
}
