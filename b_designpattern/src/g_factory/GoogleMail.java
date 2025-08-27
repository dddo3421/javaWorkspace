package g_factory;

public class GoogleMail implements SMPTConnector{
	
	private EmailConfig config;
	
	public GoogleMail(EmailConfig config) {
		super();
		this.config = config;
	}


	@Override
	public void connect() {
		System.out.println(config.url);
		System.out.println("구글 메일서버에 연결되었습니다.");
	}
	

}
