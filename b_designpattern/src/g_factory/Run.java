package g_factory;

public class Run {

	public static void main(String[] args) {
		SMPTConnector connector = ConnectorFactory.create(EmailConfig.NAVER);
		connector.connect();

	}

}
