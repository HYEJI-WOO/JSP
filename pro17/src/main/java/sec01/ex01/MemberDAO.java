package sec01.ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	private DataSource dataSource;
	
	public MemberDAO(){
		try {
			Context ctx = new InitialContext();
			Context envCtx = (Context) ctx.lookup("java:/comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<>();
		String query = "SELECT * FROM T_MEMBER ORDER BY JOINDATE DESC";
		
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
		){
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
