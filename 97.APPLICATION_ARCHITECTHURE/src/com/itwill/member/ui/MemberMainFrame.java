package com.itwill.member.ui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import com.itwill.member.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberMainFrame extends JFrame {
	/***************1. MemberService 멤버필드선언****************/
	private MemberDaoService memberDaoService;
	
	/*********로그인 한 회원********/
	private Member loginMember = null;
	
	
	private JPanel contentPane;
	private JTextField idTF;
	private JTextField nameTF;
	private JTextField addressTF;
	private JPasswordField passTF;
	private JComboBox ageCB;
	private JCheckBox marriedCK;
	private JLabel idMsgLB;
	private JTextField loginIdTF;
	private JPasswordField loginPassTF;
	private JTextField infoIdTF;
	private JPasswordField infoPassTF;
	private JTextField infoNameTF;
	private JTextField infoAddressTF;
	private JTabbedPane memberTabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberMainFrame frame = new MemberMainFrame();
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
	 */
	public MemberMainFrame() throws Exception {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\itwill\\Desktop\\이미지\\rabbit.png"));
		setTitle("회원관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 299, 542);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu memberMenu = new JMenu("회원");
		menuBar.add(memberMenu);
		
		JMenuItem loginMenuItem = new JMenuItem("로그인");
		memberMenu.add(loginMenuItem);
		
		JMenuItem joinMenuItem = new JMenuItem("회원가입");
		memberMenu.add(joinMenuItem);
		
		JMenuItem logoutMenuItem = new JMenuItem("로그아웃");
		memberMenu.add(logoutMenuItem);
		
		JSeparator separator = new JSeparator();
		memberMenu.add(separator);
		
		JMenuItem exitMenuItem = new JMenuItem("종료");
		memberMenu.add(exitMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		memberTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(memberTabbedPane, BorderLayout.CENTER);
		
		JPanel memberLoginPanel = new JPanel();
		memberLoginPanel.setForeground(new Color(255, 255, 255));
		memberLoginPanel.setBackground(new Color(179, 217, 255));
		memberTabbedPane.addTab("회원로그인", null, memberLoginPanel, null);
		memberLoginPanel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("아이디");
		lblNewLabel_5.setBounds(32, 116, 57, 15);
		memberLoginPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("패스워드");
		lblNewLabel_6.setBounds(32, 200, 57, 15);
		memberLoginPanel.add(lblNewLabel_6);
		
		loginIdTF = new JTextField();
		loginIdTF.setBounds(113, 113, 116, 21);
		memberLoginPanel.add(loginIdTF);
		loginIdTF.setColumns(10);
		
		loginPassTF = new JPasswordField();
		loginPassTF.setBounds(113, 197, 116, 21);
		memberLoginPanel.add(loginPassTF);
		
		JButton logInBtn = new JButton("로그인");
		logInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***************회원 로그인***************/
				try {
					String id = loginIdTF.getText();
					String pass = new String(loginPassTF.getPassword());
					
					int result = memberDaoService.login(id, pass);
					if(result == 0) {
						//로그인 성공
						loginProcess(id);
					}else {
						JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 일치하지 않습니다");
						loginIdTF.setSelectionStart(0);
						loginIdTF.setSelectionEnd(id.length());
						loginIdTF.requestFocus();
					}
					
				} catch (Exception e1) {
				
				}
			}
		});
		logInBtn.setBounds(32, 264, 83, 23);
		memberLoginPanel.add(logInBtn);
		
		JButton joinBtn = new JButton("회원가입");
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberTabbedPane.setSelectedIndex(1);
			}
		});
		joinBtn.setBounds(146, 264, 83, 23);
		memberLoginPanel.add(joinBtn);
		
		JPanel memberJoinPanel = new JPanel();
		memberJoinPanel.setBackground(new Color(171, 232, 254));
		memberTabbedPane.addTab("회원가입", null, memberJoinPanel, null);
		memberTabbedPane.setBackgroundAt(1, new Color(255, 255, 255));
		memberJoinPanel.setLayout(null);
		
		JLabel id = new JLabel("아이디");
		id.setBounds(38, 70, 57, 15);
		memberJoinPanel.add(id);
		
		idTF = new JTextField();
		idTF.setBounds(107, 67, 116, 21);
		memberJoinPanel.add(idTF);
		idTF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("패스워드");
		lblNewLabel_1.setBounds(38, 121, 57, 15);
		memberJoinPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("이름");
		lblNewLabel_2.setBounds(38, 170, 57, 15);
		memberJoinPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("주소");
		lblNewLabel_3.setBounds(38, 219, 57, 15);
		memberJoinPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("나이");
		lblNewLabel_4.setBounds(38, 269, 57, 15);
		memberJoinPanel.add(lblNewLabel_4);
		
		nameTF = new JTextField();
		nameTF.setBounds(107, 167, 116, 21);
		memberJoinPanel.add(nameTF);
		nameTF.setColumns(10);
		
		addressTF = new JTextField();
		addressTF.setBounds(107, 216, 116, 21);
		memberJoinPanel.add(addressTF);
		addressTF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("결혼여부");
		lblNewLabel.setBounds(38, 321, 57, 15);
		memberJoinPanel.add(lblNewLabel);
		
		passTF = new JPasswordField();
		passTF.setBounds(107, 118, 116, 21);
		memberJoinPanel.add(passTF);
		
		ageCB = new JComboBox();
		ageCB.setModel(new DefaultComboBoxModel(new String[] {"20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40"}));
		ageCB.setBounds(107, 265, 116, 23);
		memberJoinPanel.add(ageCB);
		
		marriedCK = new JCheckBox("");
		marriedCK.setBounds(107, 317, 21, 23);
		memberJoinPanel.add(marriedCK);
		
		JButton memberJoinBtn = new JButton("가입");
		memberJoinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**************회원가입************/
				try {
					/*******TextField로 부터 데이터 얻기*******/
					String id = idTF.getText();
					String password = new String(passTF.getPassword());
					String name = nameTF.getText();
					String address = addressTF.getText();
					/***************유효성 체크***************/
					if(id.equals("")) {
						idMsgLB.setText("아이디를 입력하세요.");
						idTF.requestFocus();
						return;
					}
					
					String ageStr = (String)ageCB.getSelectedItem();
					int age = Integer.parseInt(ageStr);
					// 나이는 배열 제일 처음에 나이를 선택해주세요 넣기
					char married = ' ';
					if(marriedCK.isSelected()) {
						married = 'T';
					}else {
						married = 'F';
					}
					Member newMember = new Member(id,password,name,address,age,married,null);
					boolean isAdd = memberDaoService.addMember(newMember);
					if(isAdd) {
						// 로그인화면전환
						memberTabbedPane.setSelectedIndex(1);
					}else {
						JOptionPane.showMessageDialog(null, "이미 사용하고 있는 아이디입니다.");
						idTF.requestFocus();
						idTF.setSelectionStart(0);
						idTF.setSelectionEnd(id.length());
					}
				} catch (Exception e1) {
					System.out.println("회원가입 -->" + e1.getMessage());
				}
			}
		});
		memberJoinBtn.setBounds(31, 387, 97, 23);
		memberJoinPanel.add(memberJoinBtn);
		
		JButton memberCancelBtn = new JButton("취소");
		memberCancelBtn.setBounds(145, 387, 97, 23);
		memberJoinPanel.add(memberCancelBtn);
		
		idMsgLB = new JLabel("");
		idMsgLB.setForeground(new Color(255, 128, 128));
		idMsgLB.setBounds(107, 98, 135, 15);
		memberJoinPanel.add(idMsgLB);
		
		JPanel memberInfoPanel = new JPanel();
		memberInfoPanel.setForeground(new Color(255, 255, 255));
		memberInfoPanel.setBackground(new Color(183, 183, 255));
		memberTabbedPane.addTab("회원정보", null, memberInfoPanel, null);
		memberInfoPanel.setLayout(null);
		
		JLabel id_1 = new JLabel("아이디");
		id_1.setEnabled(false);
		id_1.setBounds(39, 63, 57, 15);
		memberInfoPanel.add(id_1);
		
		infoIdTF = new JTextField();
		infoIdTF.setColumns(10);
		infoIdTF.setBounds(108, 60, 116, 21);
		memberInfoPanel.add(infoIdTF);
		
		JLabel lblNewLabel_1_1 = new JLabel("패스워드");
		lblNewLabel_1_1.setBounds(39, 114, 57, 15);
		memberInfoPanel.add(lblNewLabel_1_1);
		
		infoPassTF = new JPasswordField();
		infoPassTF.setBounds(108, 111, 116, 21);
		memberInfoPanel.add(infoPassTF);
		
		JLabel lblNewLabel_2_1 = new JLabel("이름");
		lblNewLabel_2_1.setEnabled(false);
		lblNewLabel_2_1.setBounds(39, 163, 57, 15);
		memberInfoPanel.add(lblNewLabel_2_1);
		
		infoNameTF = new JTextField();
		infoNameTF.setColumns(10);
		infoNameTF.setBounds(108, 160, 116, 21);
		memberInfoPanel.add(infoNameTF);
		
		JLabel lblNewLabel_3_1 = new JLabel("주소");
		lblNewLabel_3_1.setEnabled(false);
		lblNewLabel_3_1.setBounds(39, 212, 57, 15);
		memberInfoPanel.add(lblNewLabel_3_1);
		
		infoAddressTF = new JTextField();
		infoAddressTF.setColumns(10);
		infoAddressTF.setBounds(108, 209, 116, 21);
		memberInfoPanel.add(infoAddressTF);
		
		JLabel lblNewLabel_4_1 = new JLabel("나이");
		lblNewLabel_4_1.setEnabled(false);
		lblNewLabel_4_1.setBounds(39, 262, 57, 15);
		memberInfoPanel.add(lblNewLabel_4_1);
		
		JComboBox infoAgeCB = new JComboBox();
		infoAgeCB.setBounds(108, 258, 116, 23);
		memberInfoPanel.add(infoAgeCB);
		
		JLabel lblNewLabel_7 = new JLabel("결혼여부");
		lblNewLabel_7.setBounds(39, 314, 57, 15);
		memberInfoPanel.add(lblNewLabel_7);
		
		JCheckBox infoMarriedCK_1 = new JCheckBox("");
		infoMarriedCK_1.setBounds(108, 310, 21, 23);
		memberInfoPanel.add(infoMarriedCK_1);
		
		/***********2. 멤버필드 객체생성************/
		memberDaoService = new MemberDaoService();
		
	} // 생성자 끝
	
	
	
	
	
	private void loginProcess(String id) throws Exception {

		/***************로그인 성공시 해야할일************
		1. 로그인 성공한 멤버객체 멤버필드에 저장
		2. MemberMainFrame타이틀 변경
		3. 로그인, 회원가입탭 불활성화
		4. 회원정보보기 화면전환
		**************************************************/
		// 1. 로그인 성공한 멤버객체 멤버필드에 저장
		this.loginMember = memberDaoService.memberDaoDetail(id);
		// 2. MemberMainFrame타이틀 변경
		setTitle( id + " 님 로그인");
		// 3.로그인 화면, 회원가입화면 불활성화
		memberTabbedPane.setEnabledAt(0,false);
		memberTabbedPane.setEnabledAt(1,false);
		// 4.회원정보보기 화면
		memberTabbedPane.setSelectedIndex(2);
		
		/****회원상세데이타보여주기*****/
		infoIdTF.setText(loginMember.getM_id());
		infoPassTF.setText(loginMember.getM_password());
		infoNameTF.setText(loginMember.getM_name());
		infoAddressTF.setText(loginMember.getM_address());
		
	}
}
