package layout;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class FlowLayoutJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlowLayoutJFrame frame = new FlowLayoutJFrame();
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
	public FlowLayoutJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton_1 = new JButton("First");
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Second");
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Third");
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("Fourth");
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Fifth");
		contentPane.add(btnNewButton);
	}

}
