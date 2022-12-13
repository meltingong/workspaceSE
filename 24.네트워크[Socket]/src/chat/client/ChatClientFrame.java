package chat.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import chat.common.*;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ChatClientFrame extends JFrame {

	private JPanel contentPane;
	private JTextField chatTF;
	private JScrollPane scrollPane;
	private JTextArea displayTA;
	/******ClientClientThread객체 멤버필드로 선언******/
	private ClientClientThread client;
	private JScrollPane westScrollPane_1;
	private JList chatList;
	
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
	 * 
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public ChatClientFrame() throws Exception{
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
				String chatStr=chatTF.getText();
				if(chatStr==null|| chatStr.trim().equals("")) {
					JOptionPane.showMessageDialog(null,"데이타를 입력하세요");
					chatTF.setText("");
					chatTF.requestFocus();
					return;
				}
				
				client.send(client.getUserId()+chatStr);
				chatTF.setText("");
				chatTF.requestFocus();
				/***********************/
			}
		});
		chatTF.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(chatTF);
		chatTF.setColumns(38);

		JButton sendB = new JButton("\uC804\uC1A1");
		sendB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***********************/
				
				/***********************/
			}
		});
		panel.add(sendB);
		
		westScrollPane_1 = new JScrollPane();
		contentPane.add(westScrollPane_1, BorderLayout.WEST);
		
		chatList = new JList();
		chatList.setModel(new AbstractListModel() {
			String[] values = new String[] {"이동욱", "이종석", "김영광"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		westScrollPane_1.setViewportView(chatList);
		/********ClientClientThread객체생성*******/
		client=new ClientClientThread();
		client.start();
		setTitle(client.getUserId() + "님 안녕하세요");
		
	}//생성자

	private void displayMessage(String msg) {
		displayTA.append(msg + "\n");
		int maxSize = scrollPane.getVerticalScrollBar().getMaximum();
		scrollPane.getVerticalScrollBar().setValue(maxSize);
	}

	/*****************************************************
	 * 클라이언트쪽소켓을 사용하여 서버와 통신을 담당하는 클래스(VO)
	 *  - 서버와연결된 소켓1개를 가지고있는클래스 
	 *  - 클라이언트의 정보를가지고있는 클래스 
	 *  - 클라이언트당 1개의객체가생성
	 ****************************************************/
	public class ClientClientThread extends Thread {
		private Socket socket;
		private String id;
		private BufferedReader in;
		private PrintWriter out;
		
		public ClientClientThread()  throws Exception{
			this.socket=new Socket("192.168.15.31",8888);
			this.id = socket.getLocalAddress().getHostAddress()+"["+socket.getLocalPort()+"]";
			this.in=new BufferedReader(
						new InputStreamReader(
								socket.getInputStream(),"UTF-8"));
			this.out=new PrintWriter(
						new OutputStreamWriter(
								socket.getOutputStream(),"UTF-8"));
		}
		public String getUserId() {
			return id;
		}
		
		/*
		 *  클라이언트에서 서버로 데이타전송
		 */
		public void send(String msg) {
			
			out.println(msg);
			out.flush();
		}
		/*
		 * 서버에서 보내는 데이터를 읽기
		 */
		@Override
		public void run() {
			try {
			while(true) {
				System.out.println("A. ClientClientThread : 서버로부터 오는 데이터를 읽기위해 쓰레드 무한대기");
				
				String chatStr = in.readLine();
				String[] chatArray = chatStr.split("#");
				/*
				 * PLAIN_MSG# 안녕하세요
				 * LIST_MSG#id1%id2%id3%
				 */
					if(chatArray[0].equals(ChatProtocol.PLAIN_MSG)){
						System.out.println("B. ClientClientThread : 서버로부터 읽은 PLAIN_MSG 데이터를 클라이언트 채팅창에 보여준다.");
						displayMessage(chatArray[1]);
					}else if(chatArray[0].equals(ChatProtocol.LIST_MSG)) {
						System.out.println("B. ClientClientThread : 서버로부터 읽은 LIST_MSG 데이터로 클라이언트 List갱신");
						String[] idArray = chatArray[1].split("%");
						DefaultListModel model = new DefaultListModel();
						
						for (String id : idArray) {
							model.addElement(id);
						}
						chatList.setModel(model);
					}
				}
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

}