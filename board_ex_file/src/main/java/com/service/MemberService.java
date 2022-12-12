package com.service;

import com.dao.MemberDao;
import com.domain.MemberVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberService {
	
	private MemberDao dao;
	
	// 회원가입
	public void memberJoin(MemberVO vo) {
		dao.insertMember(vo);
	}
	
	public boolean loginService(MemberVO vo) {
		return dao.loginCheck(vo);
	}
	
	
}
