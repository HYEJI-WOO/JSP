package test;

import dao.MemberDao;
import dao.MemberDaoImpl;
import model.MemberVO;

public class MemberDaoTest {
	public static void main(String[] args) {
		MemberDao dao = MemberDaoImpl.getInstance();
		MemberVO vo = new MemberVO(
				0,
				"fefe",
				"1234",
				"페페",
				"fefe@naver.com",
				null);
		dao.addMember(vo);
		System.out.println(dao.memberList());
	}

}
