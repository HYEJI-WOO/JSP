package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import model.MemberVO;

public class MemberDaoImpl implements MemberDao {

	@Override
	public List<MemberVO> memberList() {
		List<MemberVO> list = new ArrayList<>();
		list.add(new MemberVO(1,"fefe","1234","페페","fefe@naver.com",null));
		return list;
	}

}
