<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fmt lib</title>
</head>
<body>
    <c:set var="number" value="12345678" />
    <h2>출력</h2>
    <fmt:formatNumber value="${number }" />
    <br>
    콤마제거 : <fmt:formatNumber value="${number }" type="number" groupingUsed="false"/>
    <br>

    <%-- percent --%>
    <fmt:formatNumber value="1" type="percent" />
    <br>
    <%-- 40% --%>
    <fmt:formatNumber value="0.4" type="percent" />
    <br>
    <%-- 통화 --%>
    통화 (원) : <fmt:formatNumber value="${number }" type="currency" />
    <br>
    통화 (달러) : <fmt:formatNumber value="${number }" type="currency" currencySymbol="$" />
    <fmt:formatNumber value="${number }" type="currency" currencySymbol="$" var="doller" />
    <br>
    통화 변수 출력 : ${doller }	<%-- 변수에 저장해서 사용할 수 있다 --%>

    <br>
    <h2>패턴</h2>
    <%-- 3.14 --%>
    <fmt:formatNumber value="3.14" pattern="0.0000" />
    <br>
    <fmt:formatNumber value="3.14" pattern="#.####" />
    <br>
    <fmt:formatNumber value="3.141592" pattern="#.####" />

    <h2>날짜</h2>
    <fmt:formatDate value="${today }" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" />

    <fmt:formatDate value="${today }" pattern="yyyy/MM/dd hh:mm:ss" var="dateString" />
    <br>
    데이트 문자열 변수 : ${dateString }

    <h2>문자열을 Date 객체로 변환</h2>
    <fmt:parseDate value="${dateString }" pattern="yyyy/MM/dd hh:mm:ss" var="date" />
    <fmt:formatDate value="${date }" pattern="yyyy년 MM월 dd일" />
    <%-- 
    	string -> date : pattern을 stringDate로 맞출 것
		이후 formateDate를 통해 내가 원하는 pattern화 시킬 것 
	--%>
</body>
</html>