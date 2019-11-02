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
		
		String str = request.getParameter("i_board");
		int i_board = Utils.parseStringToInt(str);
		if(i_board == 0  ) {
			return;
		}
		
		//삭제처리
		/* BoardVo vo = SBDao.delBoard(i_board); */
		
		int result = SBDao.delBoard(i_board);
		
		if(result == 0) {
			return;
		}
		
		
		response.sendRedirect("list");
		
	}		

}
