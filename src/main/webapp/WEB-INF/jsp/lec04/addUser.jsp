<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<title>회원정보 추가</title>
</head>
<body>
	<div class="container">
		<h1>회원정보 추가</h1>
		<form method="post" action="/lec04/ex01/add_user"> <!-- 나중에 셋팅 -->
		
			<label>이름 : </label> <input type="text" class="form-control" name="name">
			<label>생년월일 : </label> <input type="text" class="form-control" name="yyyymmdd">
			<label>자기소개 : </label> <textarea rows="10" cos="5" class="form-control" name="introduce"></textarea>
			<lable>취미 : </lable> <input type="text" class="form-control" name="hobby">
			
			<input type="submit" class="btn btn-success" value="추가">
		</form>
	</div>
	
</body>
</html>