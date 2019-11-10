package com.kwon1.sb;

import java.sql.*;
import java.util.*;

public class SBDao {
	public static void main(String[] args) {
		try {
			getCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Connection getCon() throws Exception {
		final String URL = "jdbc:mysql://127.0.0.1:3306/jsp?characterEncoding=UTF-8&serverTimezone=UTC";
		final String USER = "root";
		final String PW = "1234";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PW);
		System.out.println("DB 접속 성공!!");
		return con;
	}

	private static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close(con, ps);
	}

	private static void close(Connection con, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 글쓰기
	public static int insertBoard(BoardVo vo) {
		int result = 0;
		String query = " INSERT INTO t_board(title, content) VALUES (?, ?)";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getCon();
			ps = con.prepareStatement(query);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps);
		}

		return result;
	}

	// 글 리스트 가져오기
	public static List<BoardVo> getBoardList() {
		List<BoardVo> list = new ArrayList();

		String query = " SELECT i_board, title, regdatetime, cnt FROM t_board ";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = getCon();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				int i_board = rs.getInt("i_board");
				String title = rs.getString("title");
				String regDateTime = rs.getString("regdatetime");
				int cnt = rs.getInt("cnt");

				BoardVo vo = new BoardVo(i_board, title, "", regDateTime, cnt);
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}

		return list;
	}

	// 글 디테일 가져오기
	public static BoardVo getBoardDetail(int i_board) {
		BoardVo vo = null;
		String query = " SELECT * FROM t_board WHERE i_board = ? ";
		
		
		//String qry = " update t_board set cnt = ? where i_board = ?";

		Connection con = null;
		PreparedStatement ps = null;
		//PreparedStatement ptst = null;
		ResultSet rs = null;
		//int result = 0;

		try {
			con = getCon();			
			ps = con.prepareStatement(query);
			//ptst = con.prepareStatement(qry);
			ps.setInt(1, i_board);
			rs = ps.executeQuery();
			if (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String regDateTime = rs.getString("regdatetime");
				int cnt = rs.getInt("cnt");
				vo = new BoardVo(i_board, title, content, regDateTime, cnt);
			}
			//ptst.setInt(1,vo.getCnt());
			//ptst.setInt(2, i_board);
			//result = ptst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/*
			 * try { //ptst.close(); } catch (SQLException e) { // TODO Auto-generated catch
			 * block e.printStackTrace(); }
			 */
			close(con, ps, rs);
		}

		return vo;
	}

	// 글삭제
	public static int delBoard(int i_board) {
		int result = 0; // 디폴트 삭제 못 했다

		Connection con = null;
		PreparedStatement ps = null;

		String query = " DELETE FROM t_board WHERE i_board = ? ";

		try {
			con = getCon();
			ps = con.prepareStatement(query);
			ps.setInt(1, i_board);
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close(con, ps);
		}
		// 로직처리, 삭제가 잘 됐다면 result = 1;

		return result;
	}

	// 글수정
	public static int modBoard(BoardVo vo) {
		int result = 0; // 수정 실패값
		Connection con = null;
		PreparedStatement ps = null;

		String query = " UPDATE t_board SET title = ? , content = ? WHERE i_board = ? ";
		try {
			con = getCon();
			ps = con.prepareStatement(query);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			ps.setInt(3, vo.getI_board());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps);
		}

		return result;
	}
	
	//조회수 증가
	public static void plusCnt(int i_board) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String query = " update t_board set cnt = cnt+1 where i_board = ? ";
		
		try {
			con = getCon();
			ps=con.prepareStatement(query);
			ps.setInt(1, i_board);
			ps.executeUpdate();
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			close(con,ps);
		}
		
	}
	
	//댓글 달기
	public static void insertComment(CommentVo vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String query = " insert into t_comment(i_board, cmt) values (?, ?)";
		
		try {
			con = getCon();
			ps = con.prepareStatement(query);
			ps.setInt(1, vo.getI_board());
			ps.setString(2, vo.getCmt());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps);
		}
		
	}
	
	//댓글 가져오기
	public static List<CommentVo> getComment(int i_board) {
		List<CommentVo> list = new ArrayList();
		String query = " SELECT * FROM t_comment WHERE i_board = ? order by i_comment desc ";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getCon();
			ps = con.prepareStatement(query);
			ps.setInt(1, i_board);
			rs = ps.executeQuery();
			while (rs.next()) {
				CommentVo vo = new CommentVo();
				vo.setI_comment(rs.getInt("i_comment"));
				vo.setCmt(rs.getString("cmt"));
				vo.setR_datetime(rs.getString("r_datetime"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
	

		return list;

	}
	
	
	//댓글 삭제
	public static void delComment(int i_comment) {	

		Connection con = null;
		PreparedStatement ps = null;

		String query = " DELETE FROM t_comment WHERE i_comment = ? ";

		try {
			con = getCon();
			ps = con.prepareStatement(query);
			ps.setInt(1, i_comment);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close(con, ps);
		}
	
	}

	
}
