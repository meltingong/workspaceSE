package com.itwill.member;

import java.util.*;

public class MemberDaoService {
	private MemberDao memberDao;
	
	public MemberDaoService() throws Exception {
		memberDao = new MemberDao();
	}
	
	public int memberDaoWrite(Member member) throws Exception {
		return memberDao.insert(member);
	}
	
	public int memberDaoUpdate(Member member) throws Exception {
		return memberDao.update(member);
	}
	
	public int memberDaoDelete(String m_id) throws Exception {
		return memberDao.delete(m_id);
	}
	
	public Member memberDaoDetail(String m_id) throws Exception {
		return memberDao.findByPrimaryKey(m_id);
	}
	
	public List<Member> memberDaoAll() throws Exception{
		return memberDao.findAll();
	}
	

	
}
