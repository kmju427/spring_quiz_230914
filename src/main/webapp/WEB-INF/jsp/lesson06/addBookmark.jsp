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
		
		<div class="form-group">
			<label for="name">사이트명</label>
			<input type="text" id="name" class="form-control">
		</div>
		<div class="form-group">
			<label for="url">URL 주소</label>
			<input type="text" id="url" class="form-control">
		</div>
			
		<input type="button" id="addBtn" value="추가" class="btn btn-success w-100">
	</div>
	
<script>
	$(document).ready(function() {
		// 즐겨찾기 추가 버튼 클릭
		$("#addBtn").on("click", function() {
			// validation check
			let name = $("#name").val().trim();
			if (name.length < 1) {
				alert("사이트명을 입력하세요.");
				return;
			}
			
			let url = $("#url").val().trim();
			if (url.length < 1) {
				alert("주소를 입력하세요.");
				return;
			}
			
			// http or https 프로토콜 체크
			if (url.startsWith("http://") == false && url.startsWith("https://") == false) {
				alert("주소 형식이 잘못 되었습니다.");
				return;
			}
			
			// AJAX 통신
			$.ajax({
				// request
				type:"POST"
				, url:"/lesson06/add-bookmark"
				, data:{"name":name, "url":url}
				
				// response - call back 함수
				, success:function(data) { // data : JSON String -> parsing(jquery ajax 함수) -> dictionary
					if (data.code == 200) { // data.result == "성공"
						// 목록 화면으로 이동
						location.href = "/lesson06/bookmark-list-view"; // get 방식 이동
					}
				}
				, error:function(request, status, error) {
					alert("추가하는데 실패했습니다. 관리자에게 문의해주세요.");
				}
			});
		});
	});
</script>
</body>
</html>