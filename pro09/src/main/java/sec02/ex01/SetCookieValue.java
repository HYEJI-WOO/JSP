package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class SetCookieValue extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Date date = new Date(); // 현재 날짜
		
		// 쿠키 생성
		Cookie c1 = new Cookie("jsp","JSP프로그래밍");
		Cookie c2 = new Cookie("oracle", "오라클데이터베이스");
		response.addCookie(c1); // 생성된 쿠키를 브라우저로 전송
		response.addCookie(c2);
		
		out.print("현재 시간 : " + date + "<br>");
		out.print("문자열을 Cookie에 저장");
	}


}
