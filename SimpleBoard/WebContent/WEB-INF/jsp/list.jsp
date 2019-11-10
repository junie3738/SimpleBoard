<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.kwon1.sb.*"%>  
<%
	List<BoardVo> data = (List<BoardVo>)request.getAttribute("data");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>	
	#contentTitle {
		background-color: black;
		color: red;
	}	
	
	.center {
		text-align: center;
	}
	
	table {
		border-collapse: collapse;
		width: 100%;
		border: 1px solid black;
	}
	
	table td, th {
		border: 1px solid black;
	}
	
</style>
</head>
<body>
	<div id="contentTitle">보드 리스트</div>
	<div>
		<a href="write">
			<button>글쓰기</button>
		</a>
	</div>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<% if(data != null) { %>
			<% for(BoardVo vo : data) { %>
				<tr>
					<td><%=vo.getI_board() %></td>
					<td><a href="detail?i_board=<%=vo.getI_board()%>"><%=vo.getTitle() %></a></td>
					<td><%=vo.getRegDateTime() %></td>
					<td class="center"><%=vo.getCnt() %></td>
				</tr>				
			<% } %>
		<% } %>
	</table>
</body>
</html>