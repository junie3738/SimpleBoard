<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.kwon1.sb.*"%>
<%
	BoardVo vo = (BoardVo) request.getAttribute("vo");
	String msg = (String) request.getAttribute("msg");
	List<CommentVo> comment = (List<CommentVo>) request.getAttribute("comment");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
<style>
body {
	padding: 20px;
}

table {
	border-collapse: collapse;
	border: 1px solid #000;
}

th, td {
	border: 1px solid #000;
}
</style>
</head>
<body>
	<a href="list"><button>리스트로 돌아가기</button></a>
	<%
		if (vo == null) {
	%>
	<div>오류가 발생하였습니다.</div>
	<%
		} else {
	%>
	<table>
		<tr>
			<th>제목</th>
			<td colspan="3"><%=vo.getTitle()%></td>
		</tr>
		<tr>
			<td>날짜</td>
			<td><%=vo.getRegDateTime()%></td>
			<td>조회수</td>
			<td><%=vo.getCnt()%></td>
		</tr>
		<tr>
			<td colspan="4"><%=vo.getContent()%></td>
		</tr>
		<tr>
			<td colspan="2"><a href="del?i_board=<%=vo.getI_board()%>">삭제</a>
			</td>
			<td colspan="2"><a href="mod?i_board=<%=vo.getI_board()%>">수정</a>
			</td>
		</tr>
		<%
			if (msg != null) {
		%>
		<tr>
			<td>메시지</td>
			<td colspan="3"><%=msg%></td>
		</tr>
		<%
			}
		%>
	</table>
	<div>
		<form action="detail" method="post" id = "frm" onsubmit="return check()">
		<input type="hidden" name="i_comment" value = "0">
			<input type="hidden" name="i_board" value="<%=vo.getI_board()%>">
			<div>

				댓글 : <input type="text" name="comment"> <input type="submit" value="댓글달기">

			</div>
			</form>
			
			<table>
				<tr>
					<th>번호</th>
					<th>댓글</th>
					<th>등록일시</th>
					<th>삭제</th>
				</tr>
				<%
					if (comment != null && comment.size() > 0) {
				%>
				<%
					for (CommentVo cmtvo : comment) {
				%>
				<tr>
					<td><%=cmtvo.getI_comment()%></td>
					<td><%=cmtvo.getCmt()%></td>
					<td><%=cmtvo.getR_datetime()%></td>
					<td><button onclick = "delCmt(<%=cmtvo.getI_comment()%>)" >삭제</button></td>
				</tr>
				<%
					}
				%>
				<%
					}
				%>
			</table>

			</div>
	<%
		}
	%>
	<script>
	function delCmt(i_cmt){
		frm.i_comment.value = i_cmt;
		frm.submit();
	}
	function check() {
		if(frm.comment.value=="") {
			alert('댓글내용이 없습니다.');
			frm.comment.focus();
			return false;
		}
	}
	</script>
</body>
</html>