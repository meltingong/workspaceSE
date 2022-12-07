
public class ControlStopThread1 extends Thread {
	@Override
	public void run() {
		try {
			for(int i = 0; i <=100; i++) {
				System.out.println("downloading...[" + i + "%]");
				Thread.sleep(10);
			}
		} catch (Exception e) {
			
		}
		System.out.println("ControlStropThread1 : thread가 jvm return thread end");
		return;
	}
}
