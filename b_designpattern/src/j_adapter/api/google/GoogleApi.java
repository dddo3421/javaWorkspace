package j_adapter.api.google;

public class GoogleApi {
	
	public GoogleProfile getProfile(String token) {
		return new GoogleProfile("용사", "aaa@bbb.com");
	}
}
