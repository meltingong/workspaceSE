package com.itwill.shop.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JButton;

public class ProductDetailPanel extends JPanel {
	ShopMainFrame frame;
	/**
	 * Create the panel.
	 */
	public ProductDetailPanel() {
		setBackground(new Color(0, 153, 255));
		setLayout(null);
		
		JButton btnNewButton = new JButton("상품리스트 화면전환");
		btnNewButton.setBounds(51, 331, 194, 23);
		add(btnNewButton);

	}
	public void setFrame(ShopMainFrame frame) {
		this.frame=frame;
		
	}
}
