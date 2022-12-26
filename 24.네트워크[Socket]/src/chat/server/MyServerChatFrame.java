package chat.server;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.*;

import chat.server.ChatServerFrame.*;

public class MyServerChatFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea displayTA;
	private JTextField noticeTF;
	private JButton noticeBtn;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyServerChatFrame frame = new MyServerChatFrame();
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
	public MyServerChatFrame() {
		setTitle("ChatServer");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\2022-11-JAVA_DEVELOPER\\01.JAVA_FUNDMENTAL\\image\\ball.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		displayTA = new JTextArea();
		scrollPane.setViewportView(displayTA);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		noticeTF = new JTextField();
		panel.add(noticeTF);
		noticeTF.setColumns(30);
		
		noticeBtn = new JButton("공지");
		panel.add(noticeBtn);
	}
	
	private void setLog(String log) {
		displayTA.append(log + "\n");
		int maxSize = scrollPane.getVerticalScrollBar().getMaximum();
		scrollPane.getVerticalScrollBar().setValue(maxSize);
	}
	
	/*******************************************/
	
	public class ServerClientThread extends Thread{
		private String id;
		private Socket socket;
		private BufferedReader in;
		private PrintWriter out;
		
		public ServerClientThread(Socket socket) throws Exception {
			this.socket = socket;
			this.id = socket.getInetAddress().getHostAddress() + "[" + socket.getPort() + "]";
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
		}
		
		public String getUserId() {
			return id;
		}
		
		public void send(String msg) {
			out.println(msg);
			out.flush();
		}
		
		@Override
		public void run() {
			try {
				while(true) {
					String readStr = in.readLine();
					
				}
			}catch(Exception e) {
				
			}
			
		}
		
	}
	
	public class ServerClientService {
		/*
		 * 클라이언트 객체 보관 리스트
		 */
		private List<ServerClientThread> clientList = new ArrayList<ServerClientThread>();
		
		/*
		 * 클라이언트 객체 추가
		 */
		public void addClient(ServerClientThread newClient) {
			clientList.add(newClient);
			setLog(newClient.getUserId() + "님 입장");
			setLog("현재 접속자 수 : " + clientList.size() + "명");
		}
		/*
		 * 클라이언트 객체 삭제
		 */
		public void removeClient(ServerClientThread removeClient) {
			clientList.remove(removeClient);
			setLog(removeClient.getUserId() + "님 퇴장");
			setLog("현재 접속자 수 : " + clientList.size() + "명");
		}
		
	}
	
	
	public class ChatServer extends Thread{
		
		@Override
		public void run() {
			
			try {
				ServerSocket serverSocket = new ServerSocket(7800);
				
				while(true){
					
					Socket socket = serverSocket.accept();
					
				}
				
			} catch (Exception e) {
				
				
				e.printStackTrace();
			}
			
			
			
		}
		
		
	}

}
