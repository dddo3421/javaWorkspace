package g_factory;

public class ConnectorFactory {


	public static SMPTConnector create(EmailConfig config) {
		switch (config) {
		case DAUM: {			
			return new DaumMail(config);
		}
		case NAVER: {
			return new NaverMail(config);
		}
		case GOOGLE: {
			return new GoogleMail(config);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + config);
		}
	}
	
}
