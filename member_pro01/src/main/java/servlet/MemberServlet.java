package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.MemberDaoImpl;
import model.MemberVO;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	
	private MemberDao dao;

	public void setDao(MemberDao dao) {
		this.dao = dao;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 서블릿이 어떤 기능을 수행할지 결정
		String command = request.getParameter("command");
		
		if(command!=null && command.equals("addMember")) { // 회원추가
			
		} else { // 회원조회
			List<MemberVO> memberList = dao.memberList();
			System.out.println(memberList);
		}
	}
}
