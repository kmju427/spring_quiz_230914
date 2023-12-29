<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
<!-- Bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가하기</h1>
		<form>
			<div class="form-group">
				<label for="name">사이트명</label>
				<input type="text" id="name" name="name" class="form-control">
			</div>
			<div class="form-group">
				<label for="url">주소</label>
				<input type="text" id="url" name="url" class="form-control">
			</div>
			
			<input type="button" id="addBtn" value="추가" class="btn btn-success w-100">
		</form>
	</div>
	
<script>
	$(document).ready(function() {
		$("#addBtn").on("click", function() {
			// validation
			let name = $("#name").val();
			if (name.length < 1) {
				alert("사이트명을 입력하세요.");
				return;
			}
			
			let url = $("#url").val();
			if (url.length < 1) {
				alert("주소를 입력하세요.");
				return;
			}
			
			
		});
	});
</script>
</body>
</html>