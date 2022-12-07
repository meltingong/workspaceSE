import java.awt.*;

public class ConCurrentBeepThread extends Thread{
	@Override
	public void run() {
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		for(int i = 0; i < 10; i++) {
			toolKit.beep();
			System.out.println("beep!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
