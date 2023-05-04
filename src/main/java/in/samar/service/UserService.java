package in.samar.service;

import org.springframework.stereotype.Service;

import in.samar.binding.LoginForm;
import in.samar.binding.RegisterForm;

@Service
public interface UserService {

	public String registerSave(RegisterForm form);

	public String login(LoginForm form);

}
