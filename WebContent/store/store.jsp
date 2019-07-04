<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="../css/store/store.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Francois+One|Jockey+One|Noto+Sans+KR&display=swap" rel="stylesheet">
<script src="../js/jquery-3.4.0.min.js"></script>
<link rel="stylesheet"
	href="../js/bxslider-4-4.2.12/dist/jquery.bxslider.css">

<script src="../js/bxslider-4-4.2.12/dist/jquery.bxslider.js"></script>
<script>
	$(document).ready(function() {
		var main = $('.slider1').bxSlider({
			slideWidth : 650,

		});
	});
	$(document).ready(function() {
		var main = $('.slider2').bxSlider({
			slideWidth : 1200,
			minSlides : 4,
			maxSlides : 4,
			moveSlides : 4,
			infiniteLoop:false,
			hideControlOnEnd:true,

		});
	});
	$(document).ready(function() {
		var main = $('.slider3').bxSlider({
			slideWidth : 1200,
			minSlides : 4,
			maxSlides : 4,
			moveSlides : 4,
			infiniteLoop:false,
			hideControlOnEnd:true,

		});
	});
</script>
<div id="header">
	<jsp:include page="../common/_header.jsp" />
</div>
<div id="main_image">
	<!-- 이미지div -->
	<div id="main_image_text">
		<h1>매장 소개</h1>
		<h3>STORE INFOMATION</h3>
	</div>
	<div id="menu_category">
		<ul>
			<a href="#"><li>매장소개</li></a>
			<a href="./order.jsp"><li>오더하기</li></a>
		</ul>
	</div>
</div>
<div id="box">
	<h1>프롬하츠커피 매장정보</h1>
	<hr>
	<!-- 이미지밑으로 들어갈 div -->
	<div id=img_slider>
		<div class="slider1">
			<div>
				<img alt="" src="../image/store/a2.jpg" width="650px" height="650px">
			</div>
			<div>
				<img alt="" src="../image/store/a3.jpg" width="650px" height="650px">
			</div>
			<div>
				<img alt="" src="../image/store/a4.jpg" width="650px" height="650px">
			</div>
		</div>
	</div>
	<div id="text_line">
		<h3>매장주소</h3>
		<h4>서울특별시 성동구 고산지로 253 다남매Tower 1층</h4>
		<h3>영업시간(Business Hour)</h3>
		<h4>08:00 - 24:00</h4>
		<h3>매장번호 (Telephone)</h3>
		<h4>02-2282-1152</h4>
	</div>
	<div id="map">
		<h2>주변지도</h2>
		<a
			href="https://map.naver.com/?eText=%ED%94%84%EB%A1%AC%ED%95%98%EC%B8%A0%EC%BB%A4%ED%94%BC%EC%95%A4%EB%B2%A0%EC%9D%B4%EC%BB%A4%EB%A6%AC+%EC%84%B1%EB%8F%99%EA%B5%AC%EC%B2%AD%EC%A0%90&elng=2ae1b3a00f53d442dcead908aafa9f4b8c480822fca6b7624325539fa0673922&eelat=&elat=f05110ec5dca360df8037580153b2e66657407547eeec6a9df0f2ad1f38c5b54&eelng=">
			<img alt="" src="../image/store/c1.PNG" width="400px" height="400px">
		</a>
	</div>
	<div class="clear"></div>
	<div id="comunity_contact">
		<h3>이 매장을 태그한 게시글</h3>
		<hr>
		<div id="main_1">
			<div class="slider2">
				<%
					for (int i = 0; i < 12; i++) {
				%>
				<div id="community_tag">
					<img id="mempic" src="../image/community/mempic.png">
					<div id="cus_id">F_ede1245</div>
					<div id="cus_tag">#The Roof</div>
					<a href="#" /> <img src="../image/community/Cphoto1.png"
						id="picture" alt="The thumb" /></a>
						<img id="icon" src="../image/community/heartno.png">
						<img id="icon" src="../image/community/comment.jpg">

					<div id="comment">
						가정집을 개조해 만든 카페에요. 집같이 편안한데 너무 이쁜 뷰가 앞에있으니 커피맛이 더 달달한거 있죠>< <br>
						<span style="color: rgb(7, 96, 195);">#테라스#아아#달콤달콤#아늑하다</span>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
	<div id="commnet">
		<h3>리뷰</h3>
		<hr>
		<div id="main_2">
		<div class="slider3">
				<%
					for (int i = 0; i < 12; i++) {
				%>
				<div id="evaluation"><img id="mempic" src="../image/community/mempic.png">
					<div id="cus_id">아이디들어가는필드</div>
					<div id="cus_tag">#아메리카노</div>
					<a href="#" /> <img
					src="../image/store/coffee4.jpg" id="picture" alt="The thumb" /></a>
					<div id="grade">
						<div id="star_img">
							<%
								for (int j = 0; j < 5; j++) {
							%>
							<img src="../image/store/star.jpg" width="25px" height="25px">
							<%
								}
							%>
							5.0
						</div>
					</div>
					<div id="comment2">커피가 정말 맛있네요</div></li>
					</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
</div>
<div id="footer">
	<jsp:include page="../common/_footer.jsp" />
</div>


<!-- 매장소개 지도 메뉴 커뮤니티 댓글 -->