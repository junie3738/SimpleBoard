package com.kwon1.sb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/del")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("i_board"); // "3"
		
		int i_board = Utils.parseStringToInt(str); //3
		if(i_board == 0) { 
			
			response.sendRedirect("list");
			return;
		}
		
		int result = SBDao.delBoard(i_board);
		
		if(result == 0) {
			
			response.sendRedirect("detail?err=1&i_board=" + str);
			return;
		}
		//삭제처리
		
		
		response.sendRedirect("list");
	}

}

