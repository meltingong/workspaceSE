package com.itwill.member.ui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import com.itwill.member.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class MemberMainFrame extends JFrame {
	/***************1. MemberService 멤버필드선언****************/
	private MemberDaoService memberDaoService;
	
	/*********로그인 한 회원********/
	private Member loginMember = null;
	
	private int selected_index = 0;
	
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
	private JComboBox infoAgeCB;
	private JCheckBox infoMarriedCK;
	private JMenuItem loginMenuItem;
	private JMenuItem joinMenuItem;
	private JMenuItem logoutMenuItem;
	private JButton updateFormBtn;
	private JButton updateBtn;
	private JTable memberListTB;
	private JButton memberDeleteBtn;
	private JList memberListLT;
	private JComboBox memberListCB;

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
		setBounds(100, 100, 423, 585);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu memberMenu = new JMenu("회원");
		menuBar.add(memberMenu);
		
		loginMenuItem = new JMenuItem("로그인");
		loginMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberTabbedPane.setSelectedIndex(1);
			}
		});
		memberMenu.add(loginMenuItem);
		
		joinMenuItem = new JMenuItem("회원가입");
		joinMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberTabbedPane.setSelectedIndex(2);
			}
		});
		memberMenu.add(joinMenuItem);
		
		logoutMenuItem = new JMenuItem("로그아웃");
		logoutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				logoutProcess();
			}
		});
		memberMenu.add(logoutMenuItem);
		
		JSeparator separator = new JSeparator();
		memberMenu.add(separator);
		
		JMenuItem exitMenuItem = new JMenuItem("종료");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		memberMenu.add(exitMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		memberTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		memberTabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int selectedTabIndex = memberTabbedPane.getSelectedIndex();
				if(selectedTabIndex == 4) {
					displayMemberList();
				}
			}
		});
		contentPane.add(memberTabbedPane, BorderLayout.CENTER);
		
		JPanel memberMainPanel = new JPanel();
		memberTabbedPane.addTab("회원메인", null, memberMainPanel, null);
		memberMainPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel memberMainLB = new JLabel("");
		memberMainLB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(loginMember == null) {
					memberTabbedPane.setSelectedIndex(1);
				}else {
					memberTabbedPane.setSelectedIndex(3);
				}
			}
		});
		memberMainLB.setHorizontalAlignment(SwingConstants.CENTER);
		memberMainLB.setIcon(new ImageIcon(MemberMainFrame.class.getResource("/images/접시.PNG")));
		memberMainPanel.add(memberMainLB, BorderLayout.NORTH);
		
		JPanel memberLoginPanel = new JPanel();
		memberLoginPanel.setForeground(new Color(255, 255, 255));
		memberLoginPanel.setBackground(new Color(179, 217, 255));
		memberTabbedPane.addTab("회원로그인", null, memberLoginPanel, null);
		memberLoginPanel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("아이디");
		lblNewLabel_5.setBounds(59, 116, 57, 15);
		memberLoginPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("패스워드");
		lblNewLabel_6.setBounds(59, 200, 57, 15);
		memberLoginPanel.add(lblNewLabel_6);
		
		loginIdTF = new JTextField();
		loginIdTF.setBounds(140, 113, 116, 21);
		memberLoginPanel.add(loginIdTF);
		loginIdTF.setColumns(10);
		
		loginPassTF = new JPasswordField();
		loginPassTF.setBounds(140, 197, 116, 21);
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
						loginIdTF.setText("");
						loginPassTF.setText("");
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
		logInBtn.setBounds(59, 264, 83, 23);
		memberLoginPanel.add(logInBtn);
		
		JButton joinBtn = new JButton("회원가입");
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberTabbedPane.setSelectedIndex(1);
			}
		});
		joinBtn.setBounds(173, 264, 83, 23);
		memberLoginPanel.add(joinBtn);
		
		JPanel memberJoinPanel = new JPanel();
		memberJoinPanel.setBackground(new Color(171, 232, 254));
		memberTabbedPane.addTab("회원가입", null, memberJoinPanel, null);
		memberTabbedPane.setBackgroundAt(2, new Color(255, 255, 255));
		memberJoinPanel.setLayout(null);
		
		JLabel id = new JLabel("아이디");
		id.setBounds(74, 69, 57, 15);
		memberJoinPanel.add(id);
		
		idTF = new JTextField();
		idTF.setBounds(143, 66, 116, 21);
		memberJoinPanel.add(idTF);
		idTF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("패스워드");
		lblNewLabel_1.setBounds(74, 120, 57, 15);
		memberJoinPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("이름");
		lblNewLabel_2.setBounds(74, 169, 57, 15);
		memberJoinPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("주소");
		lblNewLabel_3.setBounds(74, 218, 57, 15);
		memberJoinPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("나이");
		lblNewLabel_4.setBounds(74, 268, 57, 15);
		memberJoinPanel.add(lblNewLabel_4);
		
		nameTF = new JTextField();
		nameTF.setBounds(143, 166, 116, 21);
		memberJoinPanel.add(nameTF);
		nameTF.setColumns(10);
		
		addressTF = new JTextField();
		addressTF.setBounds(143, 215, 116, 21);
		memberJoinPanel.add(addressTF);
		addressTF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("결혼여부");
		lblNewLabel.setBounds(74, 320, 57, 15);
		memberJoinPanel.add(lblNewLabel);
		
		passTF = new JPasswordField();
		passTF.setBounds(143, 117, 116, 21);
		memberJoinPanel.add(passTF);
		
		ageCB = new JComboBox();
		ageCB.setModel(new DefaultComboBoxModel(new String[] {"20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40"}));
		ageCB.setBounds(143, 264, 116, 23);
		memberJoinPanel.add(ageCB);
		
		marriedCK = new JCheckBox("");
		marriedCK.setBounds(143, 316, 21, 23);
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
		memberJoinBtn.setBounds(67, 386, 97, 23);
		memberJoinPanel.add(memberJoinBtn);
		
		JButton memberCancelBtn = new JButton("취소");
		memberCancelBtn.setBounds(181, 386, 97, 23);
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
		id_1.setBounds(64, 64, 57, 15);
		memberInfoPanel.add(id_1);
		
		infoIdTF = new JTextField();
		infoIdTF.setEnabled(false);
		infoIdTF.setColumns(10);
		infoIdTF.setBounds(133, 61, 116, 21);
		memberInfoPanel.add(infoIdTF);
		
		JLabel lblNewLabel_1_1 = new JLabel("패스워드");
		lblNewLabel_1_1.setBounds(64, 115, 57, 15);
		memberInfoPanel.add(lblNewLabel_1_1);
		
		infoPassTF = new JPasswordField();
		infoPassTF.setBounds(133, 112, 116, 21);
		memberInfoPanel.add(infoPassTF);
		
		JLabel lblNewLabel_2_1 = new JLabel("이름");
		lblNewLabel_2_1.setEnabled(false);
		lblNewLabel_2_1.setBounds(64, 164, 57, 15);
		memberInfoPanel.add(lblNewLabel_2_1);
		
		infoNameTF = new JTextField();
		infoNameTF.setColumns(10);
		infoNameTF.setBounds(133, 161, 116, 21);
		memberInfoPanel.add(infoNameTF);
		
		JLabel lblNewLabel_3_1 = new JLabel("주소");
		lblNewLabel_3_1.setEnabled(false);
		lblNewLabel_3_1.setBounds(64, 213, 57, 15);
		memberInfoPanel.add(lblNewLabel_3_1);
		
		infoAddressTF = new JTextField();
		infoAddressTF.setColumns(10);
		infoAddressTF.setBounds(133, 210, 116, 21);
		memberInfoPanel.add(infoAddressTF);
		
		JLabel lblNewLabel_4_1 = new JLabel("나이");
		lblNewLabel_4_1.setEnabled(false);
		lblNewLabel_4_1.setBounds(64, 263, 57, 15);
		memberInfoPanel.add(lblNewLabel_4_1);
		
		infoAgeCB = new JComboBox();
		infoAgeCB.setEditable(true);
		infoAgeCB.setEnabled(false);
		infoAgeCB.setModel(new DefaultComboBoxModel(new String[] {"20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40"}));
		infoAgeCB.setBounds(133, 259, 116, 23);
		memberInfoPanel.add(infoAgeCB);
		
		JLabel lblNewLabel_7 = new JLabel("결혼여부");
		lblNewLabel_7.setBounds(64, 315, 57, 15);
		memberInfoPanel.add(lblNewLabel_7);
		
		infoMarriedCK = new JCheckBox("");
		infoMarriedCK.setBounds(133, 311, 21, 23);
		memberInfoPanel.add(infoMarriedCK);
		
		updateFormBtn = new JButton("수정");
		updateFormBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String btnText = updateFormBtn.getText();
				if(btnText.equals("수정")) {
					updateFormEnable(true);
				}else if(btnText.equals("수정취소")) {
					displayMemberInfo(loginMember);
					updateFormEnable(false);
				}
				
			}
		});
		updateFormBtn.setBounds(39, 371, 97, 23);
		memberInfoPanel.add(updateFormBtn);
		
		updateBtn = new JButton("저장");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 회원 수정
				 */
				/*******TextField로 부터 데이터 얻기*******/
				try {
				String id = infoIdTF.getText();
				String password = new String(infoPassTF.getPassword());
				String name = infoNameTF.getText();
				String address = infoAddressTF.getText();
				
				String ageStr = (String)infoAgeCB.getSelectedItem();
				int age = Integer.parseInt(ageStr);
				// 나이는 배열 제일 처음에 나이를 선택해주세요 넣기
				char married = ' ';
				if(infoMarriedCK.isSelected()) {
					married = 'T';
				}else {
					married = 'F';
				}
				
				Member updateMember = new Member(id,password,name,address,age,married,null);
				memberDaoService.memberDaoUpdate(updateMember);
				loginMember = memberDaoService.memberDaoDetail(id);
				updateFormEnable(false);
				
				}catch(Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		updateBtn.setBounds(171, 371, 97, 23);
		memberInfoPanel.add(updateBtn);
		
		JPanel memberAdminPanel = new JPanel();
		memberTabbedPane.addTab("회원관리", null, memberAdminPanel, null);
		memberAdminPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 368, 121);
		memberAdminPanel.add(scrollPane);
		
		memberListTB = new JTable();
		memberListTB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selected_index = memberListTB.getSelectedRow();
				memberDeleteBtn.setEnabled(true);
				
			}
		});
		memberListTB.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"\uC544\uC774\uB514", "\uD328\uC2A4\uC6CC\uB4DC", "\uC774\uB984", "\uC8FC\uC18C", "\uB098\uC774", "\uACB0\uD63C\uC5EC\uBD80", "\uB4F1\uB85D\uC77C"
			}
		));
		scrollPane.setViewportView(memberListTB);
		
		memberListCB = new JComboBox();
		memberListCB.setModel(new DefaultComboBoxModel(new String[] {"유재석", "이동욱", "김철수", "채성아", "나미리"}));
		memberListCB.setBounds(195, 202, 112, 23);
		memberAdminPanel.add(memberListCB);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 204, 130, 195);
		memberAdminPanel.add(scrollPane_1);
		
		memberListLT = new JList();
		memberListLT.setModel(new AbstractListModel() {
			String[] values = new String[] {"유재석", "이동욱", "김철수", "채성아", "나미리", "유재석", "이동욱", "김철수", "채성아", "나미리", "유재석", "이동욱", "김철수", "채성아", "나미리"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_1.setViewportView(memberListLT);
		
		JButton memberListBtn = new JButton("회원리스트보기");
		memberListBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayMemberList();
				
			}
		});
		memberListBtn.setBounds(41, 142, 130, 23);
		memberAdminPanel.add(memberListBtn);
		
		memberDeleteBtn = new JButton("삭제");
		memberDeleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int selectedRow = memberListTB.getSelectedRow();
					if(selected_index >= 0) {
						String selectedId = (String)memberListTB.getValueAt(selectedRow,0);
						memberDaoService.memberDaoDelete(selectedId);
						displayMemberList();
					}else {
						memberDeleteBtn.setEnabled(false);
					}
				}catch(Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
	
		memberDeleteBtn.setEnabled(false);
		memberDeleteBtn.setBounds(220, 142, 97, 23);
		memberAdminPanel.add(memberDeleteBtn);
		
		/***********2. 멤버필드 객체생성************/
		memberDaoService = new MemberDaoService();
		logoutProcess();
		
		
	} // 생성자 끝
	
	/************************************/
	private void displayMemberList() {
		
		try {
			/*************회원리스트 보기[Jtable]*************/
			List<Member> memberList = memberDaoService.memberList();
			Vector columnVector = new Vector();
			columnVector.add("아이디");
			columnVector.add("패스워드");
			columnVector.add("이름");
			columnVector.add("주소");
			columnVector.add("나이");
			columnVector.add("결혼여부");
			columnVector.add("등록일");
			
			Vector tableVector = new Vector();

			for(Member member : memberList) {
				Vector rowVector = new Vector();
				rowVector.add(member.getM_id());
				rowVector.add(member.getM_password());
				rowVector.add(member.getM_name());
				rowVector.add(member.getM_address());
				rowVector.add(member.getM_age());
				rowVector.add(member.getM_married());
				rowVector.add(member.getM_regdate());
				tableVector.add(rowVector);
			}
			DefaultTableModel tableModel = new DefaultTableModel(tableVector,columnVector);
			
			memberListTB.setModel(tableModel);
			memberDeleteBtn.setEnabled(false);
			
		/*************회원리스트 보기[JList]*************/
			DefaultListModel listModel = new DefaultListModel();
			for(Member member : memberList) {
				listModel.addElement(member.getM_id());
			}
			
			memberListLT.setModel(listModel);
			
		/*************회원리스트 보기[JComboBox]*************/
			DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
			for(Member member : memberList) {
				comboBoxModel.addElement(member.getM_name() + "[" + member.getM_id() + "]");
			}
			memberListCB.setModel(comboBoxModel);
			
			
		}catch(Exception e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
		
	}
	
	
	/*******************회원정보 수정 활성화, 불활성화**********************/
	
	private void updateFormEnable(boolean b) {
		if(b) {
			//활성화
			//infoIdTF.setEnabled(true);
			infoPassTF.setEnabled(true);
			infoNameTF.setEditable(true);
			infoAddressTF.setEditable(true);
			infoAgeCB.setEnabled(true);
			infoMarriedCK.setEnabled(true);
			
			updateFormBtn.setText("수정취소");
			updateBtn.setEnabled(true);
		}else{
			//불활성화
			//infoIdTF.setEnabled(false);
			infoPassTF.setEnabled(false);
			infoNameTF.setEditable(false);
			infoAddressTF.setEditable(false);
			infoAgeCB.setEnabled(false);
			infoMarriedCK.setEnabled(false);
			
			//수정 & 저장버튼
			updateFormBtn.setText("수정");
			updateBtn.setEnabled(false);
		}
	}
	
	/*****************로그아웃 시 호출할 메소드******************/
	private void logoutProcess() {
		/***************로그인 아웃시 해야할일************
		1. 로그인 성공한 멤버객체 멤버필드에서 제거(null)
		2. MemberMainFrame타이틀 변경
		3. 로그인, 회원가입탭 활성화 /회원정보탭 불활성화
		   메뉴바 로그인, 회원가입 활성화 /로그아웃 불활성화
		4. 메인 화면전환
		**************************************************/
		//1. 로그인 성공한 멤버객체 멤버필드에서 제거(null)
		this.loginMember = null;
		
		//2. MemberMainFrame타이틀 변경
		setTitle("회원관리");
		
		//3. 로그인, 회원가입탭 활성화, 회원정보탭 불활성화
		memberTabbedPane.setEnabledAt(1,true);
		memberTabbedPane.setEnabledAt(2,true);
		memberTabbedPane.setEnabledAt(3,false);
		loginMenuItem.setEnabled(true);
		joinMenuItem.setEnabled(true);
		logoutMenuItem.setEnabled(false);
		
		//4.메인 화면전환
		memberTabbedPane.setSelectedIndex(0);
	}
	
	
	
	/***************로그인 성공 시 호출할 메소드*****************/
	private void loginProcess(String id) throws Exception {
		/***************로그인 성공시 해야할일************
		1. 로그인 성공한 멤버객체 멤버필드에 저장
		2. MemberMainFrame타이틀 변경
		3. 로그인, 회원가입탭 불활성화
		   메뉴바 로그인, 회원가입 활성화 /로그아웃 불활성화
		4. 회원정보보기 화면전환
		**************************************************/
		// 1. 로그인 성공한 멤버객체 멤버필드에 저장
		this.loginMember = memberDaoService.memberDaoDetail(id);
		
		// 2. MemberMainFrame타이틀 변경
		setTitle( id + " 님 로그인");
		
		// 3.로그인 화면, 회원가입화면 불활성화
		memberTabbedPane.setEnabledAt(1,false);
		memberTabbedPane.setEnabledAt(2,false);
		memberTabbedPane.setEnabledAt(3,true);
		loginMenuItem.setEnabled(false);
		joinMenuItem.setEnabled(false);
		logoutMenuItem.setEnabled(true);
		
		// 4.회원정보보기 화면
		memberTabbedPane.setSelectedIndex(3);
		displayMemberInfo(this.loginMember);
		
		// 5. 수정작업
		updateFormEnable(false);
	}
	/*
	 * 전역에 멤버필드에 영향을 받지 않도록 loginMember를 인자로 쓰기보단 Member를 매개변수로 하여 
	 * 멤버가 갖고있는 멤버필드에 접근한 후 메소드를 호출하는 방향으로 작성해야함
	 */
	private void displayMemberInfo(Member member) {
		/****회원상세데이타보여주기*****/
		infoIdTF.setText(member.getM_id());
		infoPassTF.setText(member.getM_password());
		infoNameTF.setText(member.getM_name());
		infoAddressTF.setText(member.getM_address());
		infoAgeCB.setSelectedItem(member.getM_age()+"");
		
		if(member.getM_married() == 'T') {
			infoMarriedCK.setSelected(true);
		}else {
			infoMarriedCK.setSelected(false);
		}
	}
}
