<%@page import="model.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MemberVO> memberList = (List<MemberVO>)request.getAttribute("memberList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
<table border=1>
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>이메일</th>
		<th>삭제</th>
	</tr>
		<% for(MemberVO vo : memberList) {%>
	<tr>
		<td><%=vo.getMno()%></td>
		<td><%=vo.getId()%></td>
		<td><%=vo.getPwd()%></td>
		<td><%=vo.getName()%></td>
		<td><%=vo.getEmail()%></td>
		<td><a href="#">삭제</a></td>
	</tr>
	<%}%>
</table>
<a href="member/joinMember.html">회원가입하기</a>

</body>
</html>