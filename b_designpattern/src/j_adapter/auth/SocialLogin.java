package j_adapter.auth;

import j_adapter.user.UserProfile;

public interface SocialLogin {
	UserProfile login(String token);
}

