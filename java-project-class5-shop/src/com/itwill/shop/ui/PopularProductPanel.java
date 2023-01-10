package com.itwill.shop.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PopularProductPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PopularProductPanel() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 71, 348, 255);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
	}
}
