<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kwon1.sb.*"%>
<%
	BoardVo vo = (BoardVo) request.getAttribute("vo");
	String msg = (String)request.getAttribute("msg");
%>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<h1>수정 화면</h1>
	<% if(msg != null) { %>
	<div><%=msg %></div>
	<% } %>
	<form action="mod" method="post">
		<input type="hidden" value = "<%=vo.getI_board()%>" name=i_board>
		<div>
			제목 : <input type="text" name="title" value = "<%=vo.getTitle()%>">
		</div>
		<div>
			내용
			<textarea name="content"><%=vo.getContent() %></textarea>
		</div>
		<input type="submit" value="글수정">
	</form>
</body>
</html>
