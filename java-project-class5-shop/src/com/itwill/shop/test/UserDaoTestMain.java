package com.itwill.shop.test;

import com.itwill.shop.user.*;

public class UserDaoTestMain {

	public static void main(String[] args) throws Exception {
		UserDao userDao = new UserDao();
		int result = userDao.insert(new User("bbbb","bbbb","비비비비","b@b.co.kr"));
		System.out.println("insert" + result);
		
	}

}
