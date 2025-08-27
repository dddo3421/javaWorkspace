package g_factory;

public class DaumMail implements SMPTConnector {
	
	private EmailConfig config;
		
	public DaumMail(EmailConfig config) {
		super();
		this.config = config;
	}


	@Override
	public void connect() {
		System.out.println(config.url);
		System.out.println("다음 메일서버에 연결되었습니다");
		
	}

}
