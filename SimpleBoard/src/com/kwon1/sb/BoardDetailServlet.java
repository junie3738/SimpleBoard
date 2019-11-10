package com.kwon1.sb;

import java.io.IOException;
import java.util.List;

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
		
		List<CommentVo> list = SBDao.getComment(i_board);
		request.setAttribute("comment", list);		
		
		request.getRequestDispatcher("WEB-INF/jsp/detail.jsp").forward(request, response);
	}	
	//댓글 달기
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		String str_comment=request.getParameter("i_comment");
		if(str_comment.contentEquals("0")) {
			
		
		
		String str_board = request.getParameter("i_board");
		
		//int i_board = Integer.parseInt(str_board);
		int i_board = Utils.parseStringToInt(str_board);
		
		if(i_board == 0 ) {
			
		}
		String cmt = request.getParameter("comment");
		
		System.out.println("i_board : " + i_board);
		System.out.println("cmt : " + cmt);
		
		CommentVo vo = new CommentVo();
		vo.setI_board(i_board);
		vo.setCmt(cmt);
		
		SBDao.insertComment(vo);
		} else {
			int i_comment = Utils.parseStringToInt(str_comment);
			SBDao.delComment(i_comment);
		}
		
		doGet(request, response); //댓글달고 다시 화면 띄어주기

	}
}

