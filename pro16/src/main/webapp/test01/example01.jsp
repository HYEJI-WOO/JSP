<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/jsvascript"></script>
<style>
#title {
	color: red;
	font-size: 20px;
}
.content {
	background-color: yellow;
}
.fs-20 {font-size: 20px; font-weight: bold;}
li {font-size: 18px; color: white; background-color: black;}
</style>
</head>
<body>

<h1 id="title">아이디 선택자01</h1>
<h1>아이디 선택자02</h1>
<h1 id="title">아이디 선택자03</h1>

<p class="content">클래스 선택자01</p>
<p class="content fs-20">클래스 선택자02</p>
<p class="content">클래스 선택자03</p>
<p>클래스 선택자04</p>

<ul>
	<li>태그선택자01</li>
	<li>태그선택자02</li>
	<li>태그선택자03</li>
	<li>태그선택자04</li>
</ul>

</body>
<script>
$(function(){ // 문서를 다 읽으면 이 코드 실행
	
});
</script>
</html>