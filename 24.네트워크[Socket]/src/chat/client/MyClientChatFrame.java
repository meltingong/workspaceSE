package chat.client;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.*;
import javax.swing.border.*;

public class MyClientChatFrame extends JFrame {

	private JPanel contentPane;
	private JTextField chatTF;
	private JScrollPane displayTA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyClientChatFrame frame = new MyClientChatFrame();
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
	public MyClientChatFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\2022-11-JAVA_DEVELOPER\\01.JAVA_FUNDMENTAL\\image\\ball.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		displayTA = new JScrollPane();
		contentPane.add(displayTA, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		chatTF = new JTextField();
		chatTF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String chatStr = chatTF.getText();
				if(chatStr == null || chatStr.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "메시지를 입력하세요");
					chatTF.setText("");
					chatTF.requestFocus();
					return;
				}
				
			}
		});
		
		chatTF.setEditable(false);
		chatTF.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		panel.add(chatTF);
		chatTF.setColumns(30);
		
		JButton sendBtn = new JButton("전송");
		panel.add(sendBtn);
	}//생성자 끝
	
	public class ClientClientThread extends Thread {
		private Socket socket;
		 
		
		
		
	}

}
