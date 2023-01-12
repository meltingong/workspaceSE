package web;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class WebServerFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea displayTA;
	WebServerThread webServerThread;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebServerFrame frame = new WebServerFrame();
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
	public WebServerFrame() {
		setTitle("WebServer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		displayTA = new JTextArea();
		displayTA.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 16));
		displayTA.setEditable(false);
		scrollPane.setViewportView(displayTA);
		/*************서버쓰레드시작******************/
		webServerThread=new WebServerThread();
		webServerThread.start();
	}
	private void displayLog(String log) {
		displayTA.append(log+"\n");
		int maxLocation=scrollPane.getVerticalScrollBar().getMaximum();
		scrollPane.getVerticalScrollBar().setValue(maxLocation);
		
		
	}
	
	/*********************************************/
	public class WebServerThread extends Thread{
		int requestCount=0;
		
		HelloServlet helloServlet = new HelloServlet();
		AddressListServlet addressListServlet = new AddressListServlet();
		
		@Override
		public void run() {
			try {
				
				ServerSocket serverSocket=new ServerSocket(80);
				displayLog("0.WebServerThread:ServerSocket생성(80)");
				
				while(true) {
					displayLog("1.WebServerThread:클라이언트연결요청대기(쓰레드대기)");
					Socket socket=serverSocket.accept();
					displayLog("2.WebServerThread:클라이언트와연결된서버쪽 소켓생성"+socket);
					BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
					displayLog("3.WebServerThread:소켓으로부터 InputStream생성");
					PrintWriter out=
							new PrintWriter(
									new OutputStreamWriter(
											socket.getOutputStream(),"UTF-8"));
					displayLog("3.WebServerThread:소켓으로부터 OutputStream생성");
					
					/***********자바코드 실행**********/
					int no = (int)(Math.random()*2+1);
					if(no%2 == 0) {
						helloServlet.service(out);
					}else {
						addressListServlet.service(out);
					}
					/***********자바코드 end**********/
					
				
					
					displayLog("4.WebServerThread:소켓으로부터 생성된OutputStream에서버시간쓰기");
					socket.close();
					displayLog("5.WebServerThread:클라이언트와연결된서버쪽 소켓닫기");
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

















