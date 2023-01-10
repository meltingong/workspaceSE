package com.itwill.shop.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JButton;

public class ProductListPanel extends JPanel {
	ShopMainFrame frame;
	/**
	 * Create the panel.
	 */
	public ProductListPanel() {
		setBackground(new Color(0, 51, 255));
		setLayout(null);
		
		JButton btnNewButton = new JButton("상세보기화면전환");
		btnNewButton.setBounds(58, 266, 173, 23);
		add(btnNewButton);

	}
	public void setFrame(ShopMainFrame frame) {
		this.frame = frame;
	}
	
}
