package sec01.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MemberDao {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "tiger";
	private Connection con; // 오라클에 연동하는데 필요한 객체
	
	public void connDB() {
		try {
			Class.forName(driver); // OracleDriver객체 생성
			// 커넥션 객체를 얻음
			con = DriverManager.getConnection(url,user,pwd);
			System.out.println("Connection 객체 생성 : "+con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		dao.connDB();
	}

}
