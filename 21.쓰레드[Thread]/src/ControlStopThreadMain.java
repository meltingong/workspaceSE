
public class ControlStopThreadMain {

	public static void main(String[] args) throws Exception {
		System.out.println("1.main");
		ControlStopThread1 cst1 = new ControlStopThread1();
		cst1.start();
		Thread.sleep(500);
		/*
		cst1.stop();
		stop 메소드 호출할 수 있으나 웬만하면 사용x 메소드 외부에 의해 종료되는거 좋지않음
		*/
		
		System.out.println("9.main thread jvm return");
	}

}
