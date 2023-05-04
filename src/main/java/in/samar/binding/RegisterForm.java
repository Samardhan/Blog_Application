package in.samar.binding;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterForm {
	private String firstName;
	private String lastName;
	private String userEmail;
	private String userPassword;
}
