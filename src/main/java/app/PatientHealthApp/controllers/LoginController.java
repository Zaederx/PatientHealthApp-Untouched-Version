package app.PatientHealthApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping("/welcome")
	public String welcome(@RequestParam(required = false, defaultValue = "Tim") String name, Model model) {
		model.addAttribute("name", name);
		return "welcome";
	}
	
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login() {
		
		String view = "login";
		return view;
	}
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String viewDefault() {
		
		String view = "login";
		return view;
	}
	
	@RequestMapping(value="home", method = RequestMethod.GET)
	public String home() {
		String view = "home";
		return view;
	}
	
	@RequestMapping(value="static", method = RequestMethod.GET)
	public String viewStatic() {
		String view = "static";
		return view;
	}
	
	@RequestMapping(value="test", method = RequestMethod.GET)
	public String test() {
		String view = "MyHelloWorld";
		return view;
	}
	
}
