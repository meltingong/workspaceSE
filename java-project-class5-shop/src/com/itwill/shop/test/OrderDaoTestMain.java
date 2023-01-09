package com.itwill.shop.test;

import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderDao;

public class OrderDaoTestMain {

	public static void main(String[] args) throws Exception {
		/*
		 * 주문1개보기
		 */
		OrderDao orderDao = new OrderDao();
		
		orderDao.insert(new Order(0,"비글외1마리",null,1050000,"bbbb"));
		
		//System.out.println(orderDao.findByOrderNo("guard1",2));
		System.out.println(orderDao.findByOrderNo("bbbb",4));
	}

}
