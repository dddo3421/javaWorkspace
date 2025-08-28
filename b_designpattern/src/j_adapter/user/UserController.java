package j_adapter.user;

import j_adapter.auth.AuthService;
import j_adapter.auth.SocialLoginProvider;

public class UserController {

	private final AuthService authservice;

	public UserController(AuthService userService) {
		super();
		this.authservice = userService;
	}
	
	public String gooleLogin() {
		authservice.socialLogin(SocialLoginProvider.GOOGLE, "abc");
		return "200 OK";
	}
	
	public String naverLogin() {
		authservice.socialLogin(SocialLoginProvider.NAVER, "abc");
		return "200 OK";
	}
	
}
