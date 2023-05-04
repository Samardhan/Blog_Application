package in.samar.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.samar.binding.BlogBind;
import in.samar.binding.LoginForm;
import in.samar.binding.RegisterForm;
import in.samar.entity.BlogUserEntity;
import in.samar.repo.UserRepo;
import in.samar.service.BlogService;
import in.samar.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService us;
	
	@Autowired
	private BlogService bs;

	@Autowired
	private UserRepo urepo;

	@Autowired
	private HttpSession session;

	@GetMapping("/")
	public String registerPage(Model m) {

		m.addAttribute("register", new RegisterForm());

		return "register";
	}

	@PostMapping("/register")
	public String saveUser(@ModelAttribute("register") RegisterForm register, Model m) {

		String save = us.registerSave(register);
		m.addAttribute("msg", save);

		return "register";
	}

	@GetMapping("/login")
	public String login(Model m) {

		m.addAttribute("login", new LoginForm());

		return "login";
	}

	@PostMapping("/login")
	public String loginPage(@ModelAttribute("login") LoginForm form, Model m) {

		String login = us.login(form);

		if (login.contains("success")) {

			return "dashboard";
		}

		m.addAttribute("msg", login);
		return "login";
	}
	
	
	@GetMapping("/dashboard")
	public String dashboard() {
		
		return "dashboard";
	}

	@GetMapping("/newpost")
	public String newPost( Model m) {
		
		
		m.addAttribute("blog",new BlogBind());
		

		return "newpost";
	}
	
	@PostMapping("/newpost")
	public String savePost(@ModelAttribute("blog") BlogBind bind,Model m) {
		
		String post = bs.newPost(bind);
		
		if(post.contains("Saved")) {
			m.addAttribute("msg", "Saved");
		}else {
			m.addAttribute("msg", "Not Saved");
		}
		
		return "newpost";
	}

	@GetMapping("/logout")
	public String logout(Model m) {

		session.invalidate();
		m.addAttribute("login", new LoginForm());
		
		return "login";
	}

}
