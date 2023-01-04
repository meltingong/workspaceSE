package com.itwill.member;

import java.util.*;

public class MemberDaoService {
	private MemberDao memberDao;
	
	public MemberDaoService() throws Exception {
		memberDao = new MemberDao();
	}
	/*
	 * 회원가입
	 * 	- 아이디가 중복된 경우에는 메세지를 띄운다.
	 */
	public boolean addMember(Member newMember) throws Exception{
		boolean isSuccess = false;
		/*
		 * 아이디 존재여부 체크
		 * 	- 아이디 존재하면 메세지
		 *  - 존재하지 않으면 가입성공
		 */
		
		if(memberDao.findByPrimaryKey(newMember.getM_id())==null) {
			int rowCount = memberDao.insert(newMember);
			isSuccess = true;
		}else {
			isSuccess = false;
		}
		return isSuccess;
	}
	/*
	 * 회원 로그인
	 */
	public int login(String id, String password) throws Exception {
		/*
		 * 0: 성공
		 * 1: 아이디 존재 안함
		 * 2: 패스워드 불일치
		 */
		int loginResult = -999;
		Member findMember = memberDao.findByPrimaryKey(id);
		if(findMember == null) {
			// 아이디 존재 안함
			loginResult = 1;
		}else {
			// 아이디 존재함
			if(password.equals(findMember.getM_password())) {
				// 패스워드 일치 (멤버가 가져야할 메소드같음 )
				loginResult = 0;
			}else {
				// 패스워드 불일치
				loginResult = 2;
			}
		}
		return loginResult;
	}
	/*
	 * 회원 아이디 중복체크
	 * 서비스에 있어야하는 메소드는 클라이언트가 직접적으로 호출하는 것만 있어야함
	 */
	public boolean isDuplicateId(String m_id) throws Exception {
		
		Member findMember = memberDao.findByPrimaryKey(m_id);
		if(findMember == null) {
			return false;
		}else {
			return true;
		}
	}
	
	/*
	 * 회원상세보기
	 */
	public Member memberDaoDetail(String m_id) throws Exception {
		return memberDao.findByPrimaryKey(m_id);
	}
	
	/*
	 * 회원수정
	 */
	public int memberDaoUpdate(Member member) throws Exception {
		return memberDao.update(member);
	}
	
	/*
	 * 회원탈퇴
	 */
	
	public int memberDaoDelete(String m_id) throws Exception {
		return memberDao.delete(m_id);
	}
	
	/* << admin >>
	 * 회원전체리스트
	 */
	public List<Member> memberList() throws Exception {
		return memberDao.findAll();
	}
	
	/*
	 * 관리자의 입장에서 필요한 기능
	 * 회원전체검색
	 * 회원이름으로검색
	 * 회원주소로검색
	 * 회원나이로검색
	 * 회원결혼여부로검색
	 * 회원가입일로검색
	 */

	
}
