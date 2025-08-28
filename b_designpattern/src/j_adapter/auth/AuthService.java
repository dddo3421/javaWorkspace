package j_adapter.auth;

import j_adapter.api.google.GoogleApi;
import j_adapter.api.google.GoogleProfile;
import j_adapter.api.naver.NaverApi;
import j_adapter.api.naver.NaverProfile;
import j_adapter.auth.adapter.GoogleAdaptor;
import j_adapter.auth.adapter.NaverAdaptor;
import j_adapter.user.UserProfile;

public class AuthService {

	public void socialLogin(SocialLoginProvider provider, String token) {
		SocialLogin socialLogin = switch (provider) {
		case NAVER -> new NaverAdaptor();
		case GOOGLE -> new GoogleAdaptor();
		default -> throw new IllegalArgumentException("Unexpected value: " + provider);
		};
		
		UserProfile userProfile = socialLogin.login(token);
		System.out.println(userProfile.username() + "로그인 로직 시작");
	}

}
