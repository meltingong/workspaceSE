package basic;

import java.awt.*;

import javax.swing.*;

public class ChildJFrame extends JFrame {
	private JPanel contentPane;
	/*
	 * 컴포넌트를 멤버필드로 선언
	 */
	private JButton okBtn;
	private JButton cancleBtn;
	
	
	public ChildJFrame() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setTitle("나의 두번째 프레임");
		
		this.contentPane = new JPanel();
		contentPane.setBackground(Color.gray);
		this.setContentPane(contentPane);
		
		/*
		 * 컴포넌트 객체 생성
		 */
		
		okBtn = new JButton("확인");
		cancleBtn = new JButton("취소");
		
		/*
		 * 컨테이너에 컴포넌트를 붙인다.
		 */
		contentPane.setLayout(null);
		okBtn.setBounds(70,250,60,30);
		cancleBtn.setBounds(160,250,60,30);
		contentPane.add(okBtn);
		contentPane.add(cancleBtn);
		
		
		
		this.setSize(300,400);
		/*
		 * 1.JFrame 객체 화면에 보여주세요
		 */
		this.setVisible(true);
		/*
		 * 1. Container[JFrame].setVisible(true);
		 * 	- 메인쓰레드가 setVisible호출하면 JVM GUI쓰레드를 생성
		 * 	- GUI쓰레드는 무한대기하면서 이벤트와 그래픽처리를 담당
		 * 	- Container[JFrame]는 계속 떠있다
		 * 	  (JVM이 종료되지 않는다.)
		 */
	}
	public static void main(String[] args) {
		new ChildJFrame();
	}
	
	
	
	

}
