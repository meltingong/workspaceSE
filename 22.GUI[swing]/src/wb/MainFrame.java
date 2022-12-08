package wb;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\2022-11-JAVA_DEVELOPER\\01.JAVA_FUNDMENTAL\\image\\penguin\\penguin1.gif"));
		setTitle("나의첫번째프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(141, 190, 231));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(281, 167, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PW");
		lblNewLabel_1.setBounds(281, 215, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("log in");
		btnNewButton.setBounds(445, 164, 69, 69);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(317, 164, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("아이디를 입력하세요");
		textField_1.setBounds(317, 212, 116, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("회원가입");
		lblNewLabel_2.setBounds(317, 290, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("아이디/비밀번호 찾기");
		lblNewLabel_3.setBounds(414, 290, 140, 15);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("아이디 저장");
		rdbtnNewRadioButton.setToolTipText("");
		rdbtnNewRadioButton.setBackground(new Color(223, 223, 223));
		rdbtnNewRadioButton.setBounds(281, 249, 121, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"로그인방법선택", "카카오", "네이버", "페이스북", "구글"}));
		comboBox.setBounds(414, 249, 140, 23);
		contentPane.add(comboBox);
	}
}
