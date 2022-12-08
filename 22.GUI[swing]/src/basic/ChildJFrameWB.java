package basic;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChildJFrameWB extends JFrame {

	private JPanel contentPane;
	private JButton okBtn;
	private JButton cancleBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChildJFrameWB frame = new ChildJFrameWB();
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
	public ChildJFrameWB() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\2022-11-JAVA_DEVELOPER\\01.JAVA_FUNDMENTAL\\image\\donut.gif"));
		setTitle("배고파");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 479);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 198, 198));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		okBtn = new JButton("확인");
		okBtn.setBackground(new Color(255, 227, 227));
		okBtn.setBounds(178, 339, 115, 35);
		contentPane.add(okBtn);
		
		cancleBtn = new JButton("취소");
		cancleBtn.setBackground(new Color(255, 227, 227));
		cancleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cancleBtn.setBounds(347, 339, 115, 35);
		contentPane.add(cancleBtn);
	}
}
