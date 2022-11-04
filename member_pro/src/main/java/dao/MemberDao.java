package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.MemberVO;

public class MemberDao implements IMemberDao {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "scott";
	private static final String PWD = "tiger";
	private Connection con; // 오라클에 연동하는데 필요한 객체
	private PreparedStatement pstmt; // 데이터베이스에 쿼리문 전달

	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		connDB();
		String query = "SELECT * FROM T_MEMBER";
		try {
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			int i=0;
			while(rs.next()) {
				// @param : 테이블 걸럼
				MemberVO vo = new MemberVO(
					rs.getString("U_ID"),
					rs.getString("PWD"),
					rs.getString("U_NAME"),
					rs.getString("EMAIL"),
					rs.getDate("JOINDATE")); 
				list.add(vo); // 리스트에 추가
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 회원가입
	public void addMember(MemberVO vo) {
		connDB();
		String id = vo.getId();
		String pwd = vo.getPassword();
		String name = vo.getName();
		String email = vo.getEmail();
		String query = "INSERT INTO T_MEMBER(U_ID, PWD, U_NAME, EMAIL) VALUES(?,?,?,?)";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void connDB() {
		try {
			Class.forName(DRIVER); // OracleDriver객체 생성
			// 커넥션 객체를 얻음
			con = DriverManager.getConnection(URL,USER,PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberVO> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
