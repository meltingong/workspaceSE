package chat.client;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ChatClientFrame extends JFrame {

	private JPanel contentPane;
	private JTextField chatTF;
	private JScrollPane scrollPane;
	private JTextArea displayTA;
	
	private ClientClientThread client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatClientFrame frame = new ChatClientFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 * 
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public ChatClientFrame() throws Exception {
		setTitle("\uCC44\uD305\uD074\uB77C\uC774\uC5B8\uD2B8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		displayTA = new JTextArea();
		displayTA.setFont(new Font("나눔고딕코딩", Font.BOLD, 17));
		displayTA.setEditable(false);
		scrollPane.setViewportView(displayTA);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.SOUTH);

		chatTF = new JTextField();
		chatTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***********************/

				/***********************/
			}
		});
		chatTF.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(chatTF);
		chatTF.setColumns(38);

		JButton sendB = new JButton("\uC804\uC1A1");
		sendB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		panel.add(sendB);
		/************************ClientClientThread 객체 생성***************************/
		client = new ClientClientThread();
		
		
		
	}//생성자

	private void displayMessage(String msg) {
		displayTA.append(msg + "\n");
		int maxSize = scrollPane.getVerticalScrollBar().getMaximum();
		scrollPane.getVerticalScrollBar().setValue(maxSize);
	}

	/*****************************************************
	 * 클라이언트쪽소켓을 사용하여 서버와 통신을 담당하는 클래스(VO) 
	 * - 서버와연결된 소켓1개를 가지고있는클래스 
	 * - 클라이언트의 정보를 가지고있는 클래스 
	 * - 클라이언트당 1개의객체가생성
	 ****************************************************/
	public class ClientClientThread extends Thread {
		private Socket socket;
		private String id;
		private BufferedReader in;
		private PrintWriter out;
		
		public ClientClientThread() throws Exception {
			this.socket = new Socket("192.168.15.9",8888);
			this.id = socket.getLocalAddress().getHostAddress() +"[" + socket.getLocalPort() + "]";
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
		}
		
		public String getUserId() {
			return id;
		}
		
		
		/*
		 * 서버로 데이터전송
		 */
		public void send(String msg) {
			out.println(msg);
			out.flush();
		}
		
		
	}

}