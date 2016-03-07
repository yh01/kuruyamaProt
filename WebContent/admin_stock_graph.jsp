<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>在庫数一覧</title>
	 <link rel="stylesheet" type="text/css" href="./css/admin_stock_graph.css">
     <link rel="stylesheet" href="././css/animate.css">
     <link rel="stylesheet" href="././css/style.css">
     <link rel="stylesheet" href="././css/bootstrap.min.css">

	 <script type="text/javascript" src="./js/modal.js"></script>
     <script type="text/javascript" src="js/jquery-2.1.4.js"></script>
	 <script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>
	 <script type="text/javascript" src="./js/jquery-1.12.0.min.js"></script>
	 <script type="text/javascript" src="./js/jPages.js"></script>
	 <script type="text/javascript" src="js/bootstrap.min.js"></script>
	 <script type="text/javascript" src="js/graphLine.js"></script>
<style>
    svg {
    	background-color:#fff;
    }
    .axis text {
        font-family: sans-serif;
        font-size: 11px;
    }
    .axis path,
    .axis line {
        fill: none;
        stroke: black;
    }
    div#graphLine{
    	overflow-x: scroll;
    }
</style>
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
			<input type="button" value="商品在庫一覧" data-toggle="modal" href="#graph">

			<br>
	<!-- モーダルの設定 -->
	<div class="modal fade" id="graph" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog  modal-lg">
			<div class="modal-content">
				<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">在庫数一覧　*棒グラフクリックで詳細表示</h4>
				</div>
				<div class="modal-body">
				<div id = "graphLine"></div>
				</div>
				<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">閉じる</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->




		</div>
	</div>
</div>
</body>
</html>