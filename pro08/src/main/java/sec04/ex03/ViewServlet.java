package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/view")
public class ViewServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		List<MemberVO> list = (List<MemberVO>) request.getAttribute("members");
		System.out.println(list);
		
		for(MemberVO vo : list) {
			String name = vo.getName();
			String email = vo.getEmail();
			out.print("<h1>이름 : " +name+ "</h1>");
			out.print("<h1>이메일 : " +email+ "</h1>");
		}
		
	}
	

}
