package sec05.exam01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sample/first")
public class FirstServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext ctx = getServletContext(); // 서블릿 컨텍스트 객체 얻기
		
		req.setAttribute("name", "fefe"); // 리퀘스트 객체에 데이터 바인딩
		ctx.setAttribute("subject", "java"); // 서블릿 컨텍스트 객체에 데이터 바인딩
		
		RequestDispatcher rd = req.getRequestDispatcher("/sample/second");
		rd.forward(req, resp);
	}
	
	

}
