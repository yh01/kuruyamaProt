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
		<s:form action="AdminGoPurchaseHistoryAction"><button type="submit">購入履歴</button></s:form>
	    <input type="button" value="問い合わせ" onclick=>
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
				<s:iterator value="historyList">
					<tr>
						<td><s:property value="salesId" /></td>
						<td><s:property value="userId" /></td>
						<td><s:property value="itemName" /></td>
						<td><s:property value="NumberOfItem" /></td>
						<td><s:property value="dateTime" /></td>
						<td><s:property value="postalCode" /></td>
						<td><s:property value="Address" /></td>
					</tr>
				</s:iterator>
			</table>

			<br>
			<div class="List1">← 1 2 3 4 →</div>
	</div>
	</div>

</div>
</body>
</html>
