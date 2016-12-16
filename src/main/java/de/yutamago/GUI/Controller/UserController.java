package de.yutamago.GUI.Controller;

import de.yutamago.Logik.Model.Entity.User;
import de.yutamago.Logik.Model.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Angelo on 16.12.2016.
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Collection<User> getUsers(Model model) {
		return userService.getUsers();
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public User getUser(@PathVariable("username") String username, Model model) {
		return userService.getUser(username);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User insertUser(@RequestBody User user, Model model) {
		return userService.insertUser(user);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(@RequestBody User user, Model model) {
		userService.updateUser(user);
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("username") String username, Model model) {
		userService.deleteUser(username);
	}
}
