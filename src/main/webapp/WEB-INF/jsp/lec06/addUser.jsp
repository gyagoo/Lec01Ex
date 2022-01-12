<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <!-- jQuery 스크립트 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<title>add User</title>
</head>
<body>
	<h1> 회원 정보 추가 </h1>
	<form method="post" action="/lec06/ex01/add_user" id="joinForm">	<button type="button" id="duplicate">중복확인</button>
		<label>이름</label> <input type="text" name="name" id="nameInput"> <br>
		<label>생년월일</label> <input type="text" name="yyyymmdd" id="yyyymmddInput"> <br>
		<label>자기소개</label> 
		<textarea rows="10" cols="50" name="introduce" id="introduceInput"></textarea> <br>
		<label>취미</label> <input type="text" name="hobby" id="hobbyInput"> <br>
		
		<!-- <button type="submit" value="추가" id="submitBtn">추가</button> -->
		<button type="button" value="추가" id="addBtn">추가</button>
	</form>

	<script>
		$(document).ready(function() {
			
			var isDuplicateName = true; // 디폴트: 중복O
			/*
			form의 실행을 중단시킨 것이 아니기 때문에 insert 됨 -> 공백 저장
			submit action을 가로채야 한다 = click -> submit event, 주체는 form tag
			tag를 객체 형태로 가져와야 함 -> id 사용
			
			여기서, return 이후 submit을 수행하게 됨
			return -> return false;
			이후 submit을 진행하지 말라는 의미
			
			어차피 redirect를 할거면 브라우저에 요청을 하는게 낫지 않을까?
			redirect: 서버가, ajax: 클라이언트가
			submit 자체를 완전 중단
			
			요청이 성공 했을 때, 실패 했을 때 페이지
			
			때에 따라서 submit event가 아니라 click event로 하기도 함
			이것은 form을 전혀 활용하지 않을 것을 의미
			
			submit 장점 = enter를 통해 event 실행 가능
			submit은 form과 함께 써야 함 ! ! !
			*/
			$("#joinForm").on("submit", function() {
				
				let name = $("#nameInput").val();
				let yyyymmdd = $("#yyyymmddInput").val();
				let introduce = $("#introduceInput").val();
				let hobby = $("#hobbyInput").val();
				
				// validation
				if(name == "") {
					alert("이름을 입력하세요");
					return false;
				}
				if(yyyymmdd == "") {
					alert("생일을 입력하세요");
					return false;
				}
				if(introduce == "") {
					alert("자기소개를 입력하세요");
					return false;
				}
				if(hobby == "") {
					alert("취미를 입력하세요");
					return false;
				}
				
				// ajax : 직접 request, 직접 response -> 그렇기 때문에 success와 error로 나누는 것
				// 삽입 성공해도 페이지 이동은 없음, 데이터 전달만
				
				$.ajax({
					type:"post",	// type="post or get"
					url:"/lec06/ex01/add_user",		// url:"파라미터를 전달할 주소"
					data:{"name":name, "yyyymmdd":yyyymmdd, "introduce":introduce, "hobby":hobby},		// dic 형태로 key-value => 파라미터 이름:실제 값
					// 성공했을 때
					success : function(data) {		// 통신 성공시 함수 수행. data에 response 값이 들어있다.
						if(data == "success") {
							alert(data);			// 또는 추가 js 코드 작성
						} else {
							alert("입력 실패");		// reponse는 규격화 해놓는 것이 좋음 -> 다양하게 사용할 수 있음
						}
						
					},
					// 실패했을 때
					error : function() {			// 통신 후 에러 발생시 함수 수행(ex. 주소 오류)
						alert("에러발생");
					}
				});
				
				return false;
			});
			
			// 비교군 button click event
			$("#addBtn").on("click", function() {
				let name = $("#nameInput").val();
				let yyyymmdd = $("#yyyymmddInput").val();
				let introduce = $("#introduceInput").val();
				let hobby = $("#hobbyInput").val();
				
				// validation
				if(name == "") {
					alert("이름을 입력하세요");
					return ;
				}
				if(yyyymmdd == "") {
					alert("생일을 입력하세요");
					return ;
				}
				if(introduce == "") {
					alert("자기소개를 입력하세요");
					return ;
				}
				if(hobby == "") {
					alert("취미를 입력하세요");
					return ;
				}
				
				$.ajax({
					type:"post",	// type="post or get"
					url:"/lec06/ex01/add_user",		// url:"파라미터를 전달할 주소"
					data:{"name":name, "yyyymmdd":yyyymmdd, "introduce":introduce, "hobby":hobby},		// dic 형태로 key-value => 파라미터 이름:실제 값
					// 성공했을 때
					success : function(data) {		// 통신 성공시 함수 수행. data에 response 값이 들어있다.
						if(data == "success") {
							alert(data);			// 또는 추가 js 코드 작성
						} else {
							alert("입력 실패");		// reponse는 규격화 해놓는 것이 좋음 -> 다양하게 사용할 수 있음
						}
						
					},
					// 실패했을 때
					error : function() {			// 통신 후 에러 발생시 함수 수행(ex. 주소 오류)
						alert("에러발생");
					}
				});
			});
			
			
			// ex02
			$("#duplicate").on("click", function() {
				let name = $("#nameInput").val();
				
				if(name == "") {
					alert("이름을 입력해 주세요");
					return;
				}
				
				// 중복체크 유효성 검사
				// 서로 다른 버튼 안에서 일어나는 이벤트
				if(isDuplicateName)	 {
					alert("중복된 이름입니다.");
					return;
				}
				
				$.ajax({
					type:post,
					url:"/lec06/ex02/duplicate_name",
					data:{"name":name},
					success : function(data) {// data 이름과 상관없이 알아서 데이터 저장
						// ajax는 json 형태로 저장되는 값들을 key-value 형태로 갖다 쓸 수 있음
						// (isDuplicate: "false")
						if(date.isDuplicate == "true") {
							alert("이름이 중복됩니다");
							isDuplicate = true;
						} else {
							alert("사용 가능합니다.");
							isDuplicate = false;	// 중복체크 해주는 함수
						}
					}, 
					
					error : function() {
						alert("에러발생");
					}
				});
				
			});
		});
	</script>
	
</body>
</html>