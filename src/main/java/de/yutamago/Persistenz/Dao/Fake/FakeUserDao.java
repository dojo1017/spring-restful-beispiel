package de.yutamago.Persistenz.Dao.Fake;

import de.yutamago.Logik.Model.Entity.User;
import de.yutamago.Persistenz.Dao.IUserDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Angelo on 16.12.2016.
 */
@Repository
@Qualifier("FakeDB")
public class FakeUserDao implements IUserDao {

	Map<String, User> users = new HashMap<>();

	@Override
	public Collection<User> getUsers() {
		return users.values();
	}

	@Override
	public User getUser(@NotNull String username) {
		return users.get(username);
	}

	@Override
	public User insertUser(User user) throws IllegalArgumentException {
		if(getUser(user.getUsername()) != null) {
			throw new IllegalArgumentException("User with this name already exists");
		}

		if(user.getUsername() == null) {
			throw new IllegalArgumentException("Username ist not set.");
		}

		users.put(user.getUsername(), user);

		return user;
	}

	@Override
	public void updateUser(User user) throws IllegalArgumentException {

		User _user = getUser(user.getUsername());

		if(_user == null) {
			throw new IllegalArgumentException("User does not exist");
		}

		_user.setPassword(user.getPassword());
		_user.setFirstName(user.getFirstName());
		_user.setLastName(user.getLastName());
		_user.setImageUrl(user.getImageUrl());
	}

	@Override
	public void deleteUser(String username) {
		if(getUser(username) == null) {
			throw new IllegalArgumentException("User with this name does not exist");
		}

		users.remove(username);
	}
}
