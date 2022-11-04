package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	
	/*
	 	데이터베이스 테이블 생성
	 	MemberVO 클래스 : 데이터베이스 테이블 컬럼과 1대1 대응이 되도록(세터게터,생성자,toString)
	 	MemberDao 클래스 : 
	      - Connection 객체 얻기 : DataSource 타입 정의
	      	 - 생성자에서 ConnectionPool을 얻어옴
	      	 - DataSource로부터 Connection객체를 얻어냄
	      - PreparedStatement 객체에 쿼리문 전달
	      - 데이터베이스 테이블에서 조회한 결과를 ResultSet객체로 얻어냄
	     	 - 결과를 순회하여 MemberVO객체에 데이터를 바인딩함
	     	 - 리스트에 추가 
	      - 리소스 반납
	    MemberServlet : 
	      - MemberDao 객체 생성 후 필요한 메소드 호출
	      - 출력
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // POST요청에 대한 한글 인코딩
		response.setContentType("text/html;charset=utf-8"); // 마임타입지정
		PrintWriter out = response.getWriter();
		
		MemberDao dao = new MemberDao();
		System.out.println(dao.list());
		
		
	}

}
