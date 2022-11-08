package sec04.ex04;

import java.util.List;

public class MemberDaoImpl implements MemberDao {

	@Override
	public List<MemberVO> memberList() {
		List<MemberVO> list = List.of(
				new MemberVO(1, "hong", "홍길동", "hong@email"),
				new MemberVO(2, "kim", "김길동", "kim@email"),
				new MemberVO(3, "park", "박길동", "park@email")
		);
				
		return list;
	}

}
