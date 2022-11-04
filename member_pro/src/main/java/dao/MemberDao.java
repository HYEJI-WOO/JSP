package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.MemberVO;

public class MemberDao implements IMemberDao {
	
	DataSource dataSource;
	
	public MemberDao() {
		try {
			Context ctx = new InitialContext();
			Context envCtx = (Context) ctx.lookup("java:/comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/oracle");
			System.out.println("커넥션풀 생성 : " + dataSource);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberVO> list() {
		List<MemberVO> members = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM T_MEMBER";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO(
						rs.getString("u_id"),
						rs.getString("u_name"),
						rs.getString("pwd"),
						rs.getString("email"),
						rs.getDate("joinDate"));
				members.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return members;
	}

}
