package event;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class ChattingJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField chatTF;
	private JButton sendBtn;
	private JTextArea chatTA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingJFrame frame = new ChattingJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChattingJFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing");
				System.exit(0);
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 341, 540);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(184, 237, 254));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("랜덤채팅");
		lblNewLabel.setIcon(new ImageIcon("C:\\2022-11-JAVA_DEVELOPER\\01.JAVA_FUNDMENTAL\\image\\1062675711_fLjaxvAE_pin.png"));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(184, 237, 254));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		chatTF = new JTextField();
		chatTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("TextField enter key");
				/*
				 * frame의 TextField와 TextArea에 접근해야함
				 */
				String chatStr = chatTF.getText();
				chatTF.setText("");
				chatTA.append(chatStr + "\n");
				chatTF.requestFocus();
				
			}
		});
		panel_1.add(chatTF);
		chatTF.setColumns(20);
		
		sendBtn = new JButton("전송");
		sendBtn.setBackground(new Color(219, 219, 219));
		panel_1.add(sendBtn);
		
		chatTA = new JTextArea();
		chatTA.setEditable(false);
		chatTA.setText("낯선상대 : ?\r\n당신 : 이게 뭐야 \n");
		contentPane.add(chatTA, BorderLayout.CENTER);
		/*
		 * 이벤트소스에 핸들러객체 등록
		 */
		ChatSendButtonActionEventHandler handler = new ChatSendButtonActionEventHandler();
		sendBtn.addActionListener(handler);
		
		
	}//생성자
	
	/*******************************InnerClass**************************************/
	
	public class ChatSendButtonActionEventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("send button click");
			/*
			 * frame의 TextField와 TextArea에 접근해야함
			 */
			String chatStr = chatTF.getText();
			chatTF.setText("");
			chatTA.append(chatStr + "\n");
			chatTF.requestFocus();
			
			
			
		}
	}

}
