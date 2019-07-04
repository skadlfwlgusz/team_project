<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="popularity_menu">
		<h3>인기상품</h3>
		<hr>
		<div id="popularity_menu_list">
			<ul>
				<li><img src="../image/store/beverage1.png" width="250px"
					height="250px"></li>
				<li><img src="../image/store/beverage2.png" width="250px"
					height="250px"></li>
				<li><img src="../image/store/beverage3.png" width="250px"
					height="250px"></li>
				<li><img src="../image/store/beverage4.png" width="250px"
					height="250px"></li>
				<div class="clear"></div>
			</ul>
		</div>
	</div>


	<div id="menulist">
	<h3>음료 메뉴</h3>
	<hr> 	
		<ul>
			<%
				for (int i = 0; i < 11; i++) {
			%>
			<li><div id="imgdiv">
					<img src="../image/store/beverage1.png" width="250px" height="250px">
				</div>
				<div id="menu_text">
					아메리카노 3500원<br>
					수량<input type="number" maxlength="2" min="1" size="2" width="30px" value="1" max="99">
				</div>
				<div id="chekbox_div">
					<input type="radio" name="hot&cold" id="HOT">
					<label for="HOT" id="radio_hot">HOT</label>
					<input type="radio" name="hot&cold" id="COLD" >
					<label for="COLD" id="radio_cold">COLD</label>
					<input type="button" value="담기">
				</div></li>
			<%
				}
			%>
			</li>
			<div class="clear"></div>
		</ul>
	</div>