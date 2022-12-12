package client;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.awt.event.ActionEvent;

public class DayTimeClientFrame extends JFrame {

	private JPanel contentPane;
	private JButton RequestServerTimeBtn;
	private JLabel timeDisplayLBL_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DayTimeClientFrame frame = new DayTimeClientFrame();
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
	public DayTimeClientFrame() {
		setTitle("DayTimeClient");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		RequestServerTimeBtn = new JButton("RequestServer Time");
		RequestServerTimeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***********************************/
				try {
					/*
					 * 1. socket 생성
					 */
					Socket socket = new Socket("192.168.15.9" , 8000);
					/*
					 * 2. socket으로부터 inputStream얻기
					 */
					
					/*
					 * InputStream[byte Stream]을 Reader[Character Stream]로 변경하는
					 * 브릿지스트림(InputStreamReader)을 사용해서 변경
					 */
					
					InputStream in = socket.getInputStream();
					InputStreamReader isr = new InputStreamReader(in,"UTF-8");
					BufferedReader br = new BufferedReader(isr);
					String serverTime = br.readLine();
					//System.out.println(serverTime);
					timeDisplayLBL_1.setText(serverTime);
					socket.close();
					
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		contentPane.add(RequestServerTimeBtn, BorderLayout.SOUTH);
		
		timeDisplayLBL_1 = new JLabel("");
		timeDisplayLBL_1.setForeground(new Color(128, 128, 255));
		timeDisplayLBL_1.setFont(new Font("Segoe Print", Font.PLAIN, 17));
		contentPane.add(timeDisplayLBL_1, BorderLayout.CENTER);
	}

}
