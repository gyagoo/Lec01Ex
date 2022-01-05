<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL ex02</title>
</head>
<body>
	<!-- if else --> 
	<h1>조건문 (if else)</h1>
	<%-- 몸무게가 70 이하면 치킨 80 이하면 샐러드 그게 아니면 굶는다 --%> 
	<c:set var="weight" value="78"/>
	
	<c:choose>
		<%-- if(weight <= 70) --%>
		<c:when test="${weight <= 70}">
			<div>치킨먹자</div>
		</c:when>
		<%-- else if(weight <= 80) --%>
		<c:when test="${weight <= 80}">
			<div>샐러드먹자</div>
		</c:when>
		<%-- else --%>
		<c:otherwise>
			<div>굶어</div>
		</c:otherwise>
	</c:choose>
	
	<h1>  반복문  </h1>
	
	<%-- 0 ~ 4 5번 반복 --%>
	<c:forEach var="i" begin="0" end="4" step="1">
		${i }
	</c:forEach>
	
	<hr>
	
	<%--16 ~ 20 --%>
	<%-- varStatus : 지금 반복문의 상태를 저장하는 변수 --%>
	<c:forEach var="i" begin="16" end="20" step="1" varStatus="status">	
		${i } ${status.current } ${status.first } ${status.last } ${status.count } ${status.index } <br>
		<%-- count, index가 주로 사용됨 --%>
	</c:forEach>
	
	<hr>
	
	<%-- model에서 전달 받은 list 반복 --%>
	<%-- for(String fruit : fruits) --%>
	<c:forEach var="fruit" items="${fruits }" varStatus="status">
	
	<%-- model로 받은 변수를 사용할 때 태그에 넣을 것 --%>
		${fruit } :: ${status.count } ${status.index } <br>	
	<%-- index는 항상 0부터 시작 --%>
	</c:forEach>
	
	<%-- model에서 전달받은 List<Map> 반복 --%>
	<c:forEach var="user" items="${users }" varStatus="status">
		<h4>${status.count }번째 회원 정보</h4>
		이름 : ${user.name } <br>
		나이 : ${user.age }	<br>
		취미 : ${user.hobby }	<br>
	</c:forEach>
	
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>나이</td>
				<td>취미</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>${user.name }</td>
					<td>${user.age }</td>
					<td>${user.hobby }</td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
</body>
</html>