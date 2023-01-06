package com.itwill.shop.test;

import com.itwill.shop.product.*;

public class ProductDaoTestMain {

	public static void main(String[] args) throws Exception {
		ProductDao productDao = new ProductDao();
		System.out.println(">> " + productDao.findByPrimaryKey(1));
		System.out.println("findAll >> " + productDao.findAll());
	}

}
