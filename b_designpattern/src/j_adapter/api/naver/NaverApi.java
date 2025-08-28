package j_adapter.api.naver;



public class NaverApi {
	
	public NaverProfile getProfile(String token) {
		return new NaverProfile("용사_naver", "aaa@naver.com");
	}
}
