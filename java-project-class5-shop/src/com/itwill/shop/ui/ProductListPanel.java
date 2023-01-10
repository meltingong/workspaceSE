package com.itwill.shop.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Rectangle;

public class ProductListPanel extends JPanel {
	ShopMainFrame frame;
	private JPanel productPanel;
	private JPanel productItemListPanel;
	/**
	 * Create the panel.
	 */
	public ProductListPanel() {
		setBackground(new Color(0, 51, 255));
		setLayout(null);
		
		JButton btnNewButton = new JButton("상세보기화면전환");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(ShopMainFrame.PRODUCT_DETAIL_PANEL, null);
			}
		});
		btnNewButton.setBounds(67, 310, 173, 23);
		add(btnNewButton);
		
		JScrollPane productListScrollPane = new JScrollPane();
		productListScrollPane.setBounds(23, 28, 262, 270);
		add(productListScrollPane);
		
		productItemListPanel = new JPanel();
		productItemListPanel.setPreferredSize(new Dimension(260, 1000));
		productListScrollPane.setViewportView(productItemListPanel);
		/***********product item start ****************/
		productPanel = new JPanel();
		productPanel.setBounds(new Rectangle(0, 0, 120, 120));
		productItemListPanel.add(productPanel);
		productPanel.setLayout(null);

	}
	public void setFrame(ShopMainFrame frame) {
		this.frame = frame;
	}
	
	public void productList() {
		productItemListPanel.removeAll();
		
	}
	
}
