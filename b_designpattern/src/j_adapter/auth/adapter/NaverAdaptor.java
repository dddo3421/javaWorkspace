package j_adapter.auth.adapter;

import j_adapter.api.naver.NaverApi;
import j_adapter.api.naver.NaverProfile;
import j_adapter.auth.SocialLogin;
import j_adapter.user.UserProfile;

public class NaverAdaptor implements SocialLogin{

	private final NaverApi api = new NaverApi();
	
	@Override
	public UserProfile login(String token) {
		NaverProfile profile = api.getProfile(token);
		return new UserProfile(profile.name(), profile.mail());
	}

}

