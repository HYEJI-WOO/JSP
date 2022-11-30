<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
<div class="content">
	<div>테스트02</div>
	<ul>
		<li>자손선택자01</li>
		<li>자손선택자02</li>
		<li>자손선택자03</li>
	</ul>
	<div>자식선택자01</div>
	<div>자식선택자02</div>
	<p>자식선택자03</p>
	<p>자식선택자04</p>
</div>
</body>
<script>
$(function(){
	$('.content div').css('border','1px solid blue')
})
</script>
</html>