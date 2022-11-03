package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sec01.ex02.BoardDao;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		BoardDao dao = new BoardDao();
		List<BoardVO> listBoards = dao.listBoards();
		
		out.print("");
		out.print("<table border=1><tr>");
		out.print("<th>번호</th>");
		out.print("<th>제목</th>");
		out.print("<th>내용</th>");
		out.print("<th>작성자</th>");
		out.print("<th>작성일</th>");
		out.print("<th>수정일</th></tr>");
		
		
		// 반복구간
		for(BoardVO vo : listBoards) {
			out.print("<tr><td>" +vo.getBno()+ "</td>");
			out.print("<td>" +vo.getTitle()+ "</td><td>" +vo.getContent()+ "</td>");
			out.print("<td>" +vo.getWriter()+ "</td><td>" +vo.getRegdate()+ "</td>");
			out.print("<td>" +vo.getUpdatedate()+ "</td></tr>");
		}
		out.print("</table>");
		
	
	}


}
