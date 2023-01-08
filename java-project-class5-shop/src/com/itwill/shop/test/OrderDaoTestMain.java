package com.itwill.shop.test;

import com.itwill.shop.order.OrderDao;

public class OrderDaoTestMain {

	public static void main(String[] args) throws Exception {
		/*
		 * 주문1개보기
		 */
		OrderDao orderDao = new OrderDao();
		
		System.out.println(orderDao.findByOrderNo("guard1",2));
	}

}
