package in.samar.serviceImpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.samar.binding.LoginForm;
import in.samar.binding.RegisterForm;
import in.samar.entity.BlogUserEntity;
import in.samar.repo.UserRepo;
import in.samar.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo urepo;

	@Autowired
	private HttpSession session;

	@Override
	public String registerSave(RegisterForm form) {

		BlogUserEntity user = new BlogUserEntity();

		BeanUtils.copyProperties(form, user);

		urepo.save(user);

		return "saved";
	}

	@Override
	public String login(LoginForm form) {

		BlogUserEntity user = urepo.findByuserEmail(form.getUserEmail());

		if (user != null) {

			if (form.getUserPassword().equals(user.getUserPassword())) {

				session.setAttribute("userId", user.getUserId());

				return "success";
			}
		}

		return "Enter Correct Details";
	}

}
