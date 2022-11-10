package dao;

import java.util.List;

import model.MemberVO;

public interface MemberDao {
	
	// 회원목록
	List<MemberVO> memberList();
	

}
