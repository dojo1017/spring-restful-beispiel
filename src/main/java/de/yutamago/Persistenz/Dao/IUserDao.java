package de.yutamago.Persistenz.Dao;

import de.yutamago.Logik.Model.Entity.User;

import java.util.Collection;

/**
 * Created by Angelo on 04.12.2016.
 */
public interface IUserDao {

	Collection<User> getUsers();

	User getUser(String username);

	User insertUser(User user);

	void updateUser(User user);

	void deleteUser(String username);
}
