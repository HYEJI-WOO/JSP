package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second")
public class SecondServlet extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String address = request.getParameter("user_address");
		
		if(id != null && id.length() != 0) {
			out.println("이미 로그인 상태입니다!<br><br>");
			out.println("첫 번째 서블릿에서 넘겨준 아이디 : " + id +"<br>");
			out.println("첫 번째 서블릿에서 넘겨준 비밀번호 : " + pw +"<br>");
			out.println("첫 번째 서블릿에서 넘겨준 주소 : " + address +"<br>");
		}else {
			out.println("로그인 하지 않았습니다.<br><br>");
			out.println("다시 로그인 하세요<br>");
			out.println("<a href'/pro09/login.html'>로그인창으로 이동하기 </>");
		}
	
	}

	

}