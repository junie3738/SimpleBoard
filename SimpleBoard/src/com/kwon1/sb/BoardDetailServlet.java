package com.kwon1.sb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str_board = request.getParameter("i_board");
		String err = request.getParameter("err");
		int i_board = Integer.parseInt(str_board);
		if(err != null) {
			switch(err) {
			case "1": 
				request.setAttribute("msg", "삭제오류가 발생하였습니다.");
				break;
			}
		} else {
			SBDao.plusCnt(i_board);
		}
		
		
		
		
		
		
		BoardVo vo = SBDao.getBoardDetail(i_board);
		request.setAttribute("vo", vo);
		
		request.getRequestDispatcher("WEB-INF/jsp/detail.jsp").forward(request, response);
	}	

}

