<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import=".*"%>
<%@ page import="com.kwon1.sb.*"%>
<%
	List<BoardVo> list = (List<BoardVo>)request.getAttribute("data"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<div>보드리스트</div>
	<div>
		<a href="write">
			<button>글쓰기</button>
		</a>
	</div>
</body>
</html>