package g_factory;

public class NaverMail implements SMPTConnector{
	
	private EmailConfig config;
	

	public NaverMail(EmailConfig config) {
		super();
		this.config = config;
	}


	@Override
	public void connect() {
		System.out.println(config.url);
		System.out.println("네이버 메일서버에 연결되었습니다.");
	}
	

}
