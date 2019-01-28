package com.ds.baza.dsbaza.controllers;

import com.ds.baza.dsbaza.commands.UserCommand;
import com.ds.baza.dsbaza.service.UserService;
import com.ds.baza.dsbaza.utils.MyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class SignupController {

	private UserService userService;

	public SignupController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/signup")
	public String signup (Model model) {
		model.addAttribute("userCommand", new UserCommand());
		//model.addAttribute("role", new Role());
        return "signup";
	}

	@PostMapping("/signup")
	public String doSignup (@Validated UserCommand user, BindingResult result, RedirectAttributes redirectAttributes){
	    if (result.hasErrors()) {
			return "signup";
		}

		userService.signup(user, user.getRole());
		//sada ce flashmessage atribut biti dodat i bice moguce da se koristi u sledecem requestu, a to je u nasem slucaju
		//homepage.
        MyUtils.flash(redirectAttributes, "success", "signupSuccess");
		return "redirect:/index";
	}
}
