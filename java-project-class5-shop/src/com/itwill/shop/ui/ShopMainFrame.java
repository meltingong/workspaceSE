package com.itwill.shop.ui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class ShopMainFrame extends JFrame {
	/*
	 * Panel상수
	 */
	public static final int PRODUCT_LIST_PANEL = 1;
	public static final int PRODUCT_DETAIL_PANEL = 2;
	public static final int USER_JOIN_PANEL = 3;
	public static final int USER_INFO_PANEL = 4;
	
	
	private JPanel contentPane;
	private JTabbedPane shopTabbedPane;
	private JTabbedPane productTabbedPane;
	private JTabbedPane memberTabbedPane;
	
	/*
	 * 1. Service 객체선언
	 */
	/*
	 * 2. 로그인 유저 객체 선언
	 */
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopMainFrame frame = new ShopMainFrame();
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
	public ShopMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 641);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JPanel globalSouthMenuPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) globalSouthMenuPanel.getLayout();
		flowLayout.setHgap(50);
		globalSouthMenuPanel.setBackground(new Color(145, 200, 255));
		contentPane.add(globalSouthMenuPanel, BorderLayout.SOUTH);
		
		JButton globalSearchMenuButton = new JButton("");
		globalSearchMenuButton.setBackground(new Color(145, 200, 255));
		globalSearchMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		globalSearchMenuButton.setBorder(null);
		globalSearchMenuButton.setOpaque(false);
		globalSearchMenuButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/search.png")));
		globalSouthMenuPanel.add(globalSearchMenuButton);
		
		JButton globalHomeMenuButton = new JButton("");
		globalHomeMenuButton.setBackground(new Color(145, 200, 255));
		globalHomeMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		globalHomeMenuButton.setOpaque(false);
		globalHomeMenuButton.setBorder(null);
		globalHomeMenuButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/shoppingmall.png")));
		globalSouthMenuPanel.add(globalHomeMenuButton);
		
		JButton globlaMemberMenuButton = new JButton("");
		globlaMemberMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		globlaMemberMenuButton.setBorder(null);
		globlaMemberMenuButton.setOpaque(false);
		globlaMemberMenuButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/user.png")));
		globalSouthMenuPanel.add(globlaMemberMenuButton);
		
		shopTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(shopTabbedPane, BorderLayout.CENTER);
		
		productTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("제품", null, productTabbedPane, null);
		
		PopularProductPanel popularProductPanel = new PopularProductPanel();
		productTabbedPane.addTab("인기제품", null, popularProductPanel, null);
		
		memberTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("회원", null, memberTabbedPane, null);
		
		MemberJoinPanel memberJoinPanel = new MemberJoinPanel();
		memberTabbedPane.addTab("회원가입", null, memberJoinPanel, null);
		/*
		 * ShopMainFrame참조를 Panel에 넘겨줌
		 */
		memberJoinPanel.frame = this;
		 
		
		
	} // 생성
	/*********************패널변경메소드********************/
	
	public void changePanel(int panel_no) {
		if(panel_no == PRODUCT_LIST_PANEL) {
			shopTabbedPane.setSelectedIndex(0);
			productTabbedPane.setSelectedIndex(0);
		}else if(panel_no == PRODUCT_DETAIL_PANEL) {
			shopTabbedPane.setSelectedIndex(0);
			productTabbedPane.setSelectedIndex(1);
		}else if(panel_no == USER_INFO_PANEL) {
			shopTabbedPane.setSelectedIndex(1);
			productTabbedPane.setSelectedIndex(1);
		}else if(panel_no == USER_JOIN_PANEL){
			shopTabbedPane.setSelectedIndex(1);
			productTabbedPane.setSelectedIndex(0);
		}
	}
	
	
	
	
}
