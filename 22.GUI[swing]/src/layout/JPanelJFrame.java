package layout;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class JPanelJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPanelJFrame frame = new JPanelJFrame();
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
	public JPanelJFrame() {
		setTitle("쇼핑몰");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\2022-11-JAVA_DEVELOPER\\01.JAVA_FUNDMENTAL\\image\\ball.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		list.setBackground(new Color(255, 227, 227));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"꼼데가르송", "아워레가시", "톰브라운", "스톤아일랜드", "아더에러", "우영미", "프라다", "jw앤더슨", "컨버스", "아미", "메종키츠네", "메종마르지엘라", "구찌", "이자벨마랑", "cp컴퍼니", "아르마니", "보테가베네타", "버버리"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		contentPane.add(list, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 227, 227));
		contentPane.add(panel, BorderLayout.NORTH);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(36);
		
		JButton btnNewButton = new JButton("검색");
		btnNewButton.setBackground(new Color(228, 228, 228));
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 227, 227));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("회원가입");
		btnNewButton_1.setBackground(new Color(219, 219, 219));
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("빠른로그인");
		btnNewButton_2.setBackground(new Color(219, 219, 219));
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("아이디찾기");
		btnNewButton_3.setBackground(new Color(219, 219, 219));
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("비밀번호찾기");
		btnNewButton_4.setBackground(new Color(219, 219, 219));
		panel_1.add(btnNewButton_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 227, 227));
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(67, 113, 57, 15);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(67, 167, 57, 15);
		panel_2.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(151, 110, 116, 21);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(151, 164, 116, 21);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("아이디저장");
		rdbtnNewRadioButton.setBackground(new Color(255, 227, 227));
		rdbtnNewRadioButton.setBounds(151, 200, 121, 23);
		panel_2.add(rdbtnNewRadioButton);
		
		JButton btnNewButton_5 = new JButton("로그인");
		btnNewButton_5.setBackground(new Color(219, 219, 219));
		btnNewButton_5.setBounds(282, 113, 97, 72);
		panel_2.add(btnNewButton_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(151, 164, 116, 21);
		panel_2.add(passwordField);
	}
}
