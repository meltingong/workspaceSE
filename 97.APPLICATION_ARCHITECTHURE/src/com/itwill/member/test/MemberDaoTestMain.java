package com.itwill.member.test;

import java.util.*;

import com.itwill.member.*;

public class MemberDaoTestMain {

	public static void main(String[] args) throws Exception {
		MemberDao memberDao=new MemberDao();
		int rowCount = memberDao.delete("aaaa");
		System.out.println("0.delete   --> " + rowCount);
		rowCount = memberDao.insert(new Member("wwww","wwww","고수","서울시 성북구",45,'F',null));
		System.out.println("1.insert   --> " + rowCount);
		rowCount = memberDao.update(new Member("dddd","dddd","유재석","서울시 압구정동",52,'T',null));
		System.out.println("2.update   --> " + rowCount);
		Member findMember = memberDao.findByPrimaryKey("bbbb");
		if(findMember != null) {
			System.out.println(" >> " +findMember);
		}else {
			System.out.println(" >> 조건을 만족하는 주소록이 존재하지 않습니다.");
		}
		System.out.println("3.selectById-> " + findMember);
		List<Member> memberList = memberDao.findAll();
		System.out.println("4.selectAll--> " + memberList);
		
	}

}
