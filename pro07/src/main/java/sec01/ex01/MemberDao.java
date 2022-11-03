package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "tiger";
	private Connection con; // 오라클에 연동하는데 필요한 객체
	private Statement stmt; // 데이터베이스에 쿼리문 전달
	
	private List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		connDB();
		String query = "SELECT * FROM T_MEMBER";
		try {
			ResultSet rs = stmt.executeQuery(query);
			int i=0;
			while(rs.next()) {
				// @param : 테이블 걸럼
				String uId = rs.getString("U_ID");
				String pwd = rs.getString("PWD");
				String uName = rs.getString("U_NAME");
				String email = rs.getString("EMAIL");
				Date date = rs.getDate("JOINDATE");
				MemberVO vo = new MemberVO(); // MemberVO객체 생성
				vo.setuId(uId);
				vo.setPwd(pwd);
				vo.setuName(uName);
				vo.setEmail(email);
				vo.setDate(date);
				list.add(vo); // 리스트에 추가
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void connDB() {
		try {
			Class.forName(driver); // OracleDriver객체 생성
			// 커넥션 객체를 얻음
			con = DriverManager.getConnection(url,user,pwd);
			System.out.println("Connection 객체 생성 : "+con);
			stmt = con.createStatement();
			System.out.println("Statement 객체 생성 : "+stmt);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
