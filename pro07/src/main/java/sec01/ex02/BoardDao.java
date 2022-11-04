package sec01.ex02;

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


public class BoardDao {
	private DataSource dataSource;
	private Connection con; // 오라클에 연동하는데 필요한 객체
	private PreparedStatement pstmt; // 데이터베이스에 쿼리문 전달
	
	public BoardDao() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/oracle");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	List<BoardVO> listBoards() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		String query = "SELECT * FROM BOARD_TBL";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			int i=0;
			while(rs.next()) {
				// @param : 테이블 걸럼
				BoardVO vo = new BoardVO(
					rs.getInt("BNO"),
					rs.getString("TITLE"),
					rs.getString("CONTENT"),
					rs.getString("WRITER"),
					rs.getDate("REGDATE"),
					rs.getDate("UPDATEDATE")); 
				list.add(vo); // 리스트에 추가
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	

}


