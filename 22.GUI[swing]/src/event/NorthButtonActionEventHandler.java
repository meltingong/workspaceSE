package event;
/*
 * ActionEvent를 처리하기 위한 핸들러는 반드시 ActionListener 인터페이스를 구현하여야 한다
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class NorthButtonActionEventHandler implements ActionListener {
	int clickCount = 0;
	ActionEventJFrame frame;
	public NorthButtonActionEventHandler(ActionEventJFrame frame) {
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("실행스레드 이름 : " + Thread.currentThread().getName());
		System.out.println("이벤트 소스 : " + e.getSource());
		/*
		 * 이벤트 소스객체 변경
		 */
		JButton source = (JButton)e.getSource();
		clickCount++;
		source.setText("이벤트소스[NORTH]" + clickCount + " 번 클릭");
		source.setBackground(Color.pink);
		source.setForeground(Color.gray);
		System.out.println("north button click!");
		/*
		 * 프레임의 타이틀변경
		 * contentPane(프레임의 멤버필드)의 배경색변경
		 * ?????
		 */
		frame.setTitle("click" + clickCount);
		int r = (int)(Math.random()*256);
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
		frame.contentPane.setBackground(new Color(r,g,b));
		
	}
	
	
	
	
	
}
