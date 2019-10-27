package com.kwon1.sb;

import java.sql.*;
import java.util.*;

public class SBDao {

	public static void main(String[] args) {
		try {
			getCon();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private static Connection getCon() throws Exception {
		final String URL = "jdbc:mysql://127.0.0.1:3306/jsp?characterEncoding=UTF-8&serverTimezone=UTC";
		final String USER = "root";
		final String PW = "1234";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PW);
		System.out.println("성공");
		return con;

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

	//글쓰기
	public static int insertBoard(BoardVo vo) {
		int result = 0;
		String query = " INSERT INTO t_board " + " (title, content) " + " VALUES " + " (?, ?) ";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getCon();
			ps = con.prepareStatement(query);
			ps.setString(1, vo.getTilte());
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
		
		String query = " SELECT * FROM t_board " ;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getCon();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				int i_board = rs.getInt("i_board");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String regDateTime = rs.getString("regdatetime");
				
				BoardVo vo = new BoardVo(i_board, title, content, regDateTime);
				list.add(vo);
			}
			
		} catch (Exception e) {			
			e.printStackTrace();
		}finally {
			

		}
		
		return list;
	}

}