<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>管理者画面　購入履歴</title>
<link rel="stylesheet" type="text/css" href="./css/admin_purchase_history.css">
<link rel="stylesheet" type="text/css" href="./css/style.css">

</head>
<body>

<div id="backimg">
<div id="site-box">
	<div id="a-box">
		<h2>管理者画面</h2>
		<input type="button" value="商品編集" onclick=>
		<input type="button" value="ユーザー編集" onclick=>
		<input type="button" value="購入履歴" onclick=> <input type="button" value="問い合わせ" onclick=>
		<input type="button" value="ログアウト" onclick="user_logout.jsp">
	</div>




	<div id="c-box">
	<h3>購入履歴</h3>


		<ul style="list-style: none">
		</ul>
		<br>
		<ul style="list-style: none">
			<li style="float: right"><input type="button" value="検索" onclick="history.back()"></li>
			<li style="float: right"><input type="text" name="cardonum" size="22" placeholder="ユーザーIDを入力"></li>
		</ul>
		<br>
		<ul style="list-style: none">
			<li style="float: right"><input type="button" value="検索" onclick="history.back()"></li>
			<li style="float: right"><input type="text" name="cardonum" size="22" placeholder="商品名を入力"></li>
		</ul>
		<br>
		<ul style="list-style: none">
			<li style="float: right"><input type="button" value="検索" onclick="history.back()"></li>
			<li style="float: right"><input type="text" name="cardonum" size="22" placeholder="注文日を入力// 2016/02/24"></li>
		</ul>

			<table>
				<tr>
					<th>購入ID</th>
					<th>ユーザーID</th>
					<th>商品名</th>
					<th>個数</th>
					<th>購入日</th>
					<th>郵便番号</th>
					<th>住所</th>
				</tr>

					<tr>

						<td>1</td>
						<td>nakagawabutyou</td>
						<td>ラーメン</td>
						<td>55</td>
						<td>2016/02/24</td>
						<td>222-2222</td>
						<td>カリフォルニア州</td>
					</tr>

					<tr>

						<td>2</td>
						<td>nakagawa</td>
						<td>塩ラーメン</td>
						<td>10</td>
						<td>2016/02/24
						<td>555-5555</td>
						<td>東京都千代田区○○○</td>
					</tr>
			</table>

			<br>
			<div class="List1">← 1 2 3 4 →</div>
	</div>
	</div>

</div>
</body>
</html>
