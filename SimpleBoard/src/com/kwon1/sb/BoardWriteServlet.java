package com.kwon1.sb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		System.out.println("title : " + title);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/write.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		System.out.println("-- doPost --");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//int intContent = Integer.parseInt(content);
		
		System.out.println("title : " + title);
		System.out.println("content : " + content);
		
		//int, char, float, byte, short, boolean, double 
		
		BoardVo vo = new BoardVo(title, content);
		
		int result = SBDao.insertBoard(vo); //여러분들은 주석처리 할 필요 없음!!
		response.sendRedirect("list");
	}

}
/*
 * import java.io.IOException;
 * 
 * import javax.servlet.RequestDispatcher; import
 * javax.servlet.ServletException; import javax.servlet.annotation.WebServlet;
 * import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * @WebServlet("/write") public class BoardWriteServlet extends HttpServlet {
 * private static final long serialVersionUID = 1L;
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { RequestDispatcher rd =
 * request.getRequestDispatcher("WEB-INF/jsp/write.jsp"); rd.forward(request,
 * response); }
 * 
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * request.setCharacterEncoding("UTF-8"); System.out.println("-- do post --");
 * String title = request.getParameter("title"); String content =
 * request.getParameter("content");
 * 
 * System.out.println("title : " + title); System.out.println("content : " +
 * content);
 * 
 * BoardVo vo = new BoardVo(title, content);
 * 
 * // 일반변수를 제외하고 모두 주소값이다. int result = SBDao.insertBoard(vo);
 * response.sendRedirect("list"); }
 * 
 * }
 */
