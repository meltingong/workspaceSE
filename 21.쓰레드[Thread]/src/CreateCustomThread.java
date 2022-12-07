
public class CreateCustomThread extends Thread {
	@Override
	public void run() {
		System.out.println("가." + Thread.currentThread().getName() + " 쓰레드 실행");
		 System.out.println("나." + Thread.currentThread().getName() + " 쓰레드 실행 후 반환");
		
	}
	
}
