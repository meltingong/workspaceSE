package com.itwill.shop.ui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;

public class MemberJoinPanel extends JPanel {
	ShopMainFrame frame;
	/**
	 * Create the panel.
	 */
	public MemberJoinPanel() {
		setBackground(new Color(255, 153, 255));
		setForeground(new Color(255, 51, 255));
		setLayout(null);
		
		JButton btnNewButton = new JButton("상세보기화면전환");
		btnNewButton.setBounds(61, 324, 158, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("제품리스트화면전환");
		btnNewButton_1.setBounds(61, 291, 158, 23);
		add(btnNewButton_1);

	}
	public void setFrame(ShopMainFrame frame) {
		this.frame = frame;
	}
}
