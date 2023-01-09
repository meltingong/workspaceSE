package com.itwill.shop.ui.김하은;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class ShopMainFrame_김하은 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopMainFrame_김하은 frame = new ShopMainFrame_김하은();
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
	public ShopMainFrame_김하은() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 614);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		ProductListPanel_김하은 productListPanel_김하은 = new ProductListPanel_김하은();
		contentPane.add(productListPanel_김하은, BorderLayout.CENTER);
	}

}
