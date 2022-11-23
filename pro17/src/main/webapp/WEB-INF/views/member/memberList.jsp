<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원목록</h1>
<c:if test="${not empty param.msg}">
	<h1>${param.msg}님이 회원가입함</h1>
</c:if>
<table border="1">
	<tr>
		<th>회원번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
		<th>가입일</th>
		<th>삭제</th>
	</tr>	
	<c:choose>
		<c:when test="${empty memberList}">
		<tr>
			<td colspan="6">등록된 회원이 없습니다.</td>
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
				<td><a href="${contextPath}/member/delMember?mno=${m.mno}">삭제</a></td>
			</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
</body>
</html>