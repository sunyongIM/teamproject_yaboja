<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join BBS</title>
<link rel="stylesheet" href="resources/css/test.css">
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm");
	String now = sdf.format(new Date());
%>
<script src="./js/jquery-3.6.0.min.js"></script>
<script src=""></script>


</head>
<body>
<form action="/" method="post">
	<table>
		<tr>
		<th colspan="3"><h2>회원가입</h2></th>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" id="id"></td>
			<td><input type="button" name="checkId" value="id확인" id="checkId"></td>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pwd" id="pwd"></td>
			<td></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" id="name"></td>
			<td></td>
		</tr>
		<tr>
			<th>메일주소</th>
			<td><input type="text" name="email" id="email"></td>
			<td></td>
		</tr>
		<tr>
			<th>가입일</th>
			<td><input type="text" value="<%=now%>" readonly="readonly"></td>
			<td></td>
		</tr>
		<tr>
			<th>구독정보</th>
			<td>
			<input type="checkbox" name ="myott" value="neflix">넷플릭스
			<input type="checkbox" name ="myott" value="disney">디즈니
			<input type="checkbox" name ="myott" value="tving">티빙
			</td>
			<td></td>
		</tr>
		<tr>
			<th colspan="3"><input type="submit" value="가입"></th>
		</tr>
		
	</table>
	</form>
</body>
</html>