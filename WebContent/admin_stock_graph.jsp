<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在庫数一覧</title>
	 <link rel="stylesheet" type="text/css" href="./css/admin_custmor.css">
     <link rel="stylesheet" href="././css/animate.css">
     <link rel="stylesheet" href="././css/style.css">
     <script type="text/javascript" src="js/jquery-2.1.4.js"></script>
	 <script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>
	 <script type="text/javascript" src="js/graphLine.js"></script>
</head>
<body>
<div id="site-box">
	<div id="backimg">
		<div id="title">
			<h2>管理者画面</h2>
			<input type="button" value="商品編集" onclick="history.back()">
			<input type="button" value="在庫数一覧" onclick="history.back()">
			<input type="button" value="ユーザー編集" onclick="history.back()">
			<input type="button" value="購入履歴" onclick="history.back()">
			<input type="button" value="問い合わせ" onclick="history.back()">
			<input type="button" value="ログアウト" onclick="history.back()">

			<div id="c-box"><h3>　　在庫数一覧 *棒グラフクリックで詳細表示</h3></div>
			<br>
			<div id = "graphLine"></div>
		</div>
	</div>
</div>
</body>
</html>