package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sess4")
public class SessionTest4 extends HttpServlet {
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(); // 세션 생성
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		if(session.isNew()) { // 최초 요청시 (post 요청)
			if(id!=null && !id.equals("")) {
				session.setAttribute("user_id", id);
				out.print("<a href='sess4'>로그인 상태 확인</a>");
			} else { 
				out.print("<a href='login2.html'>다시로그인하기</a>");
				session.invalidate();
			}
		} else { // 재요청 (get 요청)
			id = (String) session.getAttribute("user_id");
			if(id!=null && !id.equals("")) {
				out.print("안녕하세요 " + id + "님");
			} else { 
				out.print("<a href='login2.html'>다시로그인하기</a>");
				session.invalidate();
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
}
}