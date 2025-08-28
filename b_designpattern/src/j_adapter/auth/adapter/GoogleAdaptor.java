package j_adapter.auth.adapter;

import j_adapter.api.google.GoogleApi;
import j_adapter.api.google.GoogleProfile;
import j_adapter.auth.SocialLogin;
import j_adapter.user.UserProfile;

public class GoogleAdaptor implements SocialLogin{

	private final GoogleApi api = new GoogleApi();
	
	@Override
	public UserProfile login(String token) {
		GoogleProfile profile = api.getProfile(token);
		return new UserProfile(profile.username(), profile.email());
	}

}
