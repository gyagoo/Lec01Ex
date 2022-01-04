<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL lib</title>
</head>
<body>
	<h2> 변수 정의 하기 (c:set) </h2>
	
	<!-- int number1 = 100 -->
	<c:set var="number1" value="100" />
	<h4> ${number1}</h4>
	
	<c:set var="number2">200</c:set>
	<h4> ${number2}</h4>
	
	<h4>${number1+number2 }</h4>
	
	<h1>변수 출력하기 (c:out)</h1>
	<h4><c:out value="900"/></h4>	<!-- 출력하고 싶은 값 입력 -->
	<h4><c:out value="${number1 }" /></h4>
	
	<c:out value="<script>alert('출력')</script>" />	<!-- 해당하는 태그가 실행되지 않고 화면에 그대로 출력 -->
	<c:out value="<script>alert('출력')</script>" escapeXml="true"/> <!-- 위 코드에서 생략된 부분 -->
	<!-- 
	<c:out value="<script>alert('출력')</script>" escapeXml="false"/>  
	 -->	
	
	
	<h2>조건문</h2>
	
	<c:if test="true">
		<h4>조건이 참</h4>
	</c:if>
	
	<!-- if(number1 > 50) -->
	<c:if test="${number1 > 50 }">	<!-- 따옴표 주의 ! ! ! -->
		<h4>number1은 50보다 크다</h4>
	</c:if>
	
	<c:if test="${number1 eq 100 }">	<!-- equals -->
		
	</c:if>
	
	<c:if test="${number ne 200 }">	<!-- not equals -->
	
	</c:if>
	
	<c:if test="${!empty number1 }">	<!-- isEmpty -->
		<h4>비어 있지 않다</h4>
	</c:if>
</body>
</html>