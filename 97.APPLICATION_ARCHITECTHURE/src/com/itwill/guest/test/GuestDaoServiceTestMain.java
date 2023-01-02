package com.itwill.guest.test;

import com.itwill.guest.*;

public class GuestDaoServiceTestMain {

	public static void main(String[] args) throws Exception {
		
		GuestDaoService guestDaoService = new GuestDaoService();
		
		System.out.println("1. 게스트 추가");
		Guest newGuest = new Guest(0, "훈이", null, "hoon2@gmail.com", "http://www.itwill.co.kr", "게스트", "2023년이라니");
		System.out.println(">> " + guestDaoService.guestDaoWrite(newGuest));
		
		System.out.println("2. 게스트 번호로 찾기");
		Guest findGuest = guestDaoService.guestDaoDetail(5);
		System.out.println(">> " + findGuest);
		
		System.out.println("3. 게스트 수정");
		findGuest.setGuest_name("유리");
		findGuest.setGuest_email("yuri@gmail.com");
		findGuest.setGuest_title("나는 유리");
		findGuest.setGuest_content("훈이야 꺼져");
		System.out.println(">> " + guestDaoService.guestDaoUpdate(findGuest));
		
		System.out.println("4. 게스트 삭제");
		System.out.println(">> " + guestDaoService.guestDaoDelete(30));
		System.out.println(">> " + guestDaoService.guestDaoDelete(31));
		System.out.println(">> " + guestDaoService.guestDaoDelete(32));
		System.out.println(">> " + guestDaoService.guestDaoDelete(33));
		
		System.out.println("5. 게스트 리스트");
		System.out.println(">> " + guestDaoService.guestDaoAll());
		
	}

}
