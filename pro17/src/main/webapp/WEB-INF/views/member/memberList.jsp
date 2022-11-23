<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원목록</h1>
<table border="1">
	<tr>
		<th>회원번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
		<th>가입일</th>
	</tr>	
	<c:choose>
		<c:when test="${empty memberList}">
		<tr>
			<td colspan="5">등록된 회원이 없습니다.</td>
		</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${memberList}" var="m">
			<tr>
				<td>${m.mno}</td>
				<td>${m.id}</td>
				<td>${m.name}</td>
				<td>${m.email}</td>
				<td>${m.joinDate}</td>
			</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
</body>
</html>