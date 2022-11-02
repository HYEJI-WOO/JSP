package sec03.ex04;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	
	private static MemberDao dao = new MemberDao();
	private Map<String, String> members = new HashMap<String, String>();
	private MemberDao() {
		members.put("fefe", "1234");
		members.put("pori", "5484");
		members.put("bobo", "9571");
		
	}
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	public String login(String id, String pw) {
		String value = members.get(id);
		if(pw.equals(value)) {
			System.out.println("로그인 성공");
			return id;
		}
		return "fail";
	}
}
