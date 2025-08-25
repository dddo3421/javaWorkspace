package b_designpattern.com.mc.oop.a_encapsulation.method;

public class SummerConcert {

	public static void start() {
		System.out.println(" Summer concert를 시작합니다. ^^**********");
		Player player = new Player("바이올린");
		player.play();
		System.out.println("===============================================");
	}
}