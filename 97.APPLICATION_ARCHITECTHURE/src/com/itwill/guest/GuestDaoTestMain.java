package com.itwill.guest;

import java.util.List;

public class GuestDaoTestMain {

	public static void main(String[] args)throws Exception {
				
		GuestDao guestDao=new GuestDao();
		System.out.println("1.insert");
		int rowCount = guestDao.insert(new Guest(0,"철수",null,"guard@gmail.com","http://www.itwill.co.kr","되는걸까","들어가라"));
		rowCount = guestDao.insert(new Guest(0,"유리",null,"yuri@gmail.com","http://www.itwill.co.kr","되는걸까","들어가라"));
		System.out.println("insert : " + rowCount);
		System.out.println("2.delete");
		rowCount = guestDao.delete(0);
		System.out.println("3.update");
		rowCount = guestDao.update(new Guest(3,"이름수정",null,"1234@naver.com","http://www.itwill.co.kr","아휴","힘들어"));
		System.out.println("4.findByPrimarykey");
		Guest findGuest = guestDao.findByGuest(3);
		System.out.println(findGuest);
		System.out.println("5.findAll");
		List<Guest> guestList = guestDao.findByAllGuest();
		System.out.println(guestList);
	}

}
