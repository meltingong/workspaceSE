package com.itwill.shop.ui;

import javax.swing.*;

public class MemberJoinPanel extends JPanel {
	ShopMainFrame frame;
	/**
	 * Create the panel.
	 */
	public MemberJoinPanel() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("가입");
		btnNewButton.setBounds(47, 383, 97, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBounds(209, 383, 97, 23);
		add(btnNewButton_1);

	}
}
