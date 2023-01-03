package com.itwill.member.test;

import javax.swing.*;

import com.itwill.member.*;

public class MemberDaoServiceTestMain {

	public static void main(String[] args) throws Exception {
		
		MemberDaoService memberDaoService = new MemberDaoService();
		
		System.out.println("1. 회원가입");
		boolean addSuccess1 =
					memberDaoService.addMember(new Member("qqqq", "qqqq", "채성아", "떡잎마을", 28, 'T', null));
		if(addSuccess1) {
			System.out.println("로그인화면으로 이동");
		}else {
			JOptionPane.showMessageDialog(null, "중복된 아이디입니다.");
		}
		
		boolean addSuccess2 =
					memberDaoService.addMember(new Member("bbbb", "bbbb", "채성아", "떡잎마을", 28, 'T', null));
		
		if(addSuccess2) {
			System.out.println("로그인화면으로 이동");
		}else {
			JOptionPane.showMessageDialog(null, "중복된 아이디입니다.");
		}
		
		System.out.println("2. 로그인");
		System.out.println(">> " + memberDaoService.login("bbbb", "bbbb"));
		System.out.println(">> " + memberDaoService.login("bbbb", "1234"));
		System.out.println(">> " + memberDaoService.login("zzzz", "bbbb"));
		
		System.out.println("3. 중복아이디체크");
		System.out.println(">> " + memberDaoService.isDuplicateId("aaaa"));
		System.out.println(">> " + memberDaoService.isDuplicateId("bbbb"));
		
		
		
	}

}
