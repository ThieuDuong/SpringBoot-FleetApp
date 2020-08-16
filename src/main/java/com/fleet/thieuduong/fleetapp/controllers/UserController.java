package com.fleet.thieuduong.fleetapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.fleet.thieuduong.fleetapp.models.User;
import com.fleet.thieuduong.fleetapp.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public String getUsers(Model model) {
		return "User";
	}

	@PostMapping(value = "user/addNew")
	public RedirectView addNew(User user, RedirectAttributes redir) {
		userService.saveUser(user);
		RedirectView redirectView = new RedirectView("/login", true);
		redir.addFlashAttribute("message", "You successfully registered! You can now login");
		return redirectView;
	}

	@RequestMapping("/user/findById")
	@ResponseBody
	public Optional<User> getUserById(int id) {
		return userService.getUserById(id);
	}

	@RequestMapping(value = "/user/edit", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateUser(User User) {
		userService.saveUser(User);
		return "redirect:/users";
	}

	@RequestMapping(value = "/user/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteUser(int id) {
		userService.deleteUser(id);
		return "redirect:/users";
	}
}
