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
		
		
		
	}

}
