package com.itwill.member.test;

import com.itwill.member.*;

public class MemberDaoServiceTestMain {

	public static void main(String[] args) throws Exception {
		
		MemberDaoService memberDaoService = new MemberDaoService();
		
		System.out.println("1. 멤버 추가");
		Member newMember = new Member("qqqq", "qqqq", "채성아", "떡잎마을", 28, 'T', null);
		System.out.println(">> " + memberDaoService.memberDaoWrite(newMember));
		
		System.out.println("2. 멤버 찾기");
		Member findMember = memberDaoService.memberDaoDetail("dddd");
		System.out.println(">> " + findMember);
		
		System.out.println("3. 멤버 수정");
		findMember.setM_password("zzzz");
		findMember.setM_name("원장님");
		findMember.setM_age(54);
		System.out.println(">> " + memberDaoService.memberDaoUpdate(findMember));
		
		System.out.println("4. 멤버 삭제");
		System.out.println(">> " + memberDaoService.memberDaoDelete("qqqq"));
		
		System.out.println("5. 멤버 리스트");
		System.out.println(">> " + memberDaoService.memberDaoAll());
		
	}

}
